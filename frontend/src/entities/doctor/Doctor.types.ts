import {UserDetails} from "@/entities/user/UserDetails";

type Doctor = {
    id: number;
    userDetailsDto: UserDetails;
    specialization: Specialization;
}

type AppointmentSlot = {
    id: number;
    date: Date;
    timeFrom: Date;
    timeTo: Date;
    doctorId: number;
}

enum Specialization {
    GENERAL_PRACTICE = 'GENERAL_PRACTICE',
    SURGERY = 'SURGERY',
    INTERNAL_MEDICINE = 'INTERNAL_MEDICINE',
    RADIOLOGY = 'RADIOLOGY',
    DENTISTRY = 'DENTISTRY',
    CARDIOLOGY = 'CARDIOLOGY',
    ONCOLOGY = 'ONCOLOGY',
    NEUROLOGY = 'NEUROLOGY',
    OPHTHALMOLOGY = 'OPHTHALMOLOGY',
    DERMATOLOGY = 'DERMATOLOGY',
    ANESTHESIOLOGY = 'ANESTHESIOLOGY',
    PATHOLOGY = 'PATHOLOGY',
    ZOOLOGY = 'ZOOLOGY',
    WILDLIFE_MEDICINE = 'WILDLIFE_MEDICINE',
    AVIAN_MEDICINE = 'AVIAN_MEDICINE',
    EQUINE_MEDICINE = 'EQUINE_MEDICINE',
    EXOTIC_ANIMALS = 'EXOTIC_ANIMALS',
}

export {Specialization};
export type {Doctor, AppointmentSlot};