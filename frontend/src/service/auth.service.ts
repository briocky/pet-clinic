import {LoginDto, LoginResponse, RegisterDto, RegisterResponse} from "@/entities/auth/Auth.types";
import {axiosInstance as axios} from "@/axios/axios";

const refreshTokenUrl = 'api/refreshToken';

async function loginUser(data: LoginDto): Promise<LoginResponse> {
    const loginEndpoint = 'api/login';
    const response = await axios.post<LoginResponse>(loginEndpoint, data);
    return response.data as LoginResponse;
}

async function register(data: RegisterDto): Promise<RegisterResponse> {
    const registerEndpoint = 'api/register';
    const response = await axios.post<RegisterResponse>(registerEndpoint, data)
    return response.data as RegisterResponse;
}

async function refreshToken(): Promise<LoginResponse> {
    const response = await axios.get<LoginResponse>(refreshTokenUrl)
    return response.data as LoginResponse;
}

export {loginUser, register, refreshToken, refreshTokenUrl}