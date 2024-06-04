import {AuthorizationData} from "@/entities/auth/Auth.types";
import {createSlice, PayloadAction} from "@reduxjs/toolkit";
import {UserDetails} from "@/entities/user/UserDetails";

const initialState: AuthorizationData = {
    userDetails: null,
    isLoggedIn: false,
};

const authSlice = createSlice({
    name: 'auth',
    initialState,
    reducers: {
        login: (state, action: PayloadAction<UserDetails>) => {
            return {
                ...state,
                isLoggedIn: true,
                userDetails: action.payload
            };
        },
        logout: (state) => {
            state.isLoggedIn = false;
            state.userDetails = null;
        },
    },
});

export const {login, logout} = authSlice.actions;

export default authSlice.reducer;