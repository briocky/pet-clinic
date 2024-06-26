import axios from "axios";
import {getToken, setToken} from "@/service/token.service";
import {refreshToken, refreshTokenUrl} from "@/service/auth.service";

const host = process.env.NEXT_PUBLIC_API_URL;

const axiosInstance = axios.create({
    baseURL: host,
    withCredentials: true
});

const authAxios = axios.create({
    baseURL: host
});

authAxios.interceptors.request.use(
    (config) => {
        const token = getToken();

        if (token) {
            config.headers.Authorization = `Bearer ${token}`;
        }

        return config;
    });

authAxios.interceptors.response.use(
    (response) => response,
    async (error) => {
        const originalRequest = error.config;
        if ((error.response.status === 401 &&
                error.config.url !== refreshTokenUrl) ||
            !originalRequest._retry) {
            originalRequest._retry = true;
            await refreshToken()
                .then((accessToken) => {
                    setToken(accessToken.accessToken)
                });
            originalRequest.headers.Authorization = `Bearer ${getToken()}`;

            return axios(originalRequest).then((response) => response);
        }
        return Promise.reject(error);
    });

export {authAxios, axiosInstance};