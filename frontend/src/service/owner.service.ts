import {authAxios as axios} from '@/axios/axios';
import {AppointmentSlot, Doctor} from "@/entities/doctor/Doctor.types";
import {PatientDto} from "@/entities/patient/Patient.types";
import {Appointment} from "@/entities/appointment/Appointment.types";

async function getAvailableDoctors(): Promise<Doctor[]> {
    const availableDoctorsEndpoint = 'api/owner/appointments/availableDoctors';
    const response = await axios.get<Doctor[]>(availableDoctorsEndpoint);
    return response.data as Doctor[];
}

async function getDoctorAvailableAppointmentDays(doctorId: number): Promise<AppointmentSlot[]> {
    const availableDoctorDaysEndpoint = `api/owner/appointments/doctor/${doctorId}/availableAppointmentDays`;
    const response = await axios.get<AppointmentSlot[]>(availableDoctorDaysEndpoint);
    return response.data as AppointmentSlot[];
}

async function getDoctorAvailableAppointmentHourSlots(doctorId: number, date: Date): Promise<AppointmentSlot[]> {
    const standardizedDate = new Date(date).toISOString().split('T')[0];
    const availableDoctorHourSlotsEndpoint = `api/owner/appointments/doctor/${doctorId}/availableAppointmentHourSlots?date=${standardizedDate}`;
    const response = await axios.get<AppointmentSlot[]>(availableDoctorHourSlotsEndpoint);
    return response.data as AppointmentSlot[];
}

async function getPets(): Promise<PatientDto[]> {
    const petsEndpoint = `api/owner/pets/all`;
    const response = await axios.get<PatientDto[]>(petsEndpoint);
    return response.data as PatientDto[];
}

async function newAppointment(): Promise<Appointment[]> {
    const newAppointmentEndpoint = `api/owner/appointments/new`;
    const response = await axios.get<Appointment[]>(newAppointmentEndpoint);
    return response.data as Appointment[];
}

export {
    getPets,
    getAvailableDoctors,
    getDoctorAvailableAppointmentDays,
    getDoctorAvailableAppointmentHourSlots
};