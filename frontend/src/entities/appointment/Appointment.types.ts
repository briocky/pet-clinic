import {PatientDto} from "@/entities/patient/Patient.types";
import {Doctor} from "@/entities/doctor/Doctor.types";
import {User} from "@/entities/user/User";
import {Invoice} from "@/entities/invoice/Invoice.types";

type Appointment = {
    id: number;
    dateTime: Date;
    patientDto: PatientDto;
    ownerDto: User;
    doctorDto: Doctor;
    invoiceDto: Invoice;
}

export type {Appointment}