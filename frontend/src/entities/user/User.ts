import {UserDetails} from "@/entities/user/UserDetails";

type User = {
  id: string;
  role: 'DOCTOR' | 'USER';
  userDetails: UserDetails;
}

export type {User};