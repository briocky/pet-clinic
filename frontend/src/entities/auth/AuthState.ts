import {User} from "@/entities/user/User";

type AuthState = {
  user: User | null;
  isLoggedIn: boolean;
}

export type {AuthState}