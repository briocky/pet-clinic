import {SystemRole} from "@/entities/user/SystemRole";

type UserDetails = {
  id: number;
  firstName: string;
  lastName: string;
  email: string;
  phoneNumber: string;
  address: string;
  birthDate: Date;
  imageUrl: string;
  systemRole: SystemRole;
}

export type {UserDetails};