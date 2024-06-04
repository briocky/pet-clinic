import {PatientDto} from "@/entities/patient/Patient.types";
import {SystemRole} from "@/entities/user/SystemRole";
import {UserDetails} from "@/entities/user/UserDetails";

type AuthorizationData = {
    userDetails: UserDetails | null;
    isLoggedIn: boolean;
}

type LoginDto = {
    email: string;
    password: string;
}

type RegisterDto = {
    email: string;
    password: string;
    confirmPassword: string;
    firstName: string;
    lastName: string;
    address: string;
    phoneNumber: string;
    birthDate: Date;
    pets: PatientDto[];
}

type LoginResponse = {
    id: number;
    name: string;
    email: string;
    phoneNumber: string;
    address: string;
    birthDate: Date;
    imageUrl: string;
    systemRole: SystemRole;
    accessToken: string;
}

type RegisterResponse = {
    id: number;
    email: string;
    name: string;
    accessToken: string;
}

export type {AuthorizationData, LoginDto, RegisterDto, RegisterResponse, LoginResponse}