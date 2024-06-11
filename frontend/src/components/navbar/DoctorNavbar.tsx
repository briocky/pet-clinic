"use client";

import React from 'react';
import Link from 'next/link';
import { useRouter } from "next/navigation";
import Image from "next/image";
import UserAvatar from "@/components/user-avatar/UserAvatar";

const DoctorNavbar = () => {
    const router = useRouter();

    return (
        <header className="flex justify-between items-center px-10 pt-10">
            <Image width={200} height={200} src={'/images/logo.svg'} alt={'logo'}/>
            <nav className="space-x-10 rounded-3xl bg-white drop-shadow-2xl py-3 px-12">
                <Link href="/doctor/appointments" className="hover:underline">
                    Appointments
                </Link>
                <Link href="/doctor/patients" className="hover:underline">
                    Patients
                </Link>
                <Link href="/doctor/calendar" className="hover:underline">
                    Calendar
                </Link>
                <Link href="/doctor/profile" className="hover:underline">
                    Profile
                </Link>
                <Link href="/contacts" className="hover:underline">
                    Contacts
                </Link>
            </nav>
            <div className="text-sm text-right text-gray-700">
                <img src={'https://img.freepik.com/free-photo/doctor-offering-medical-teleconsultation_23-2149329007.jpg'} alt="Doctor Avatar"
                     className="h-12 w-12 rounded-full object-cover"/>
            </div>
        </header>
    );
};

export default DoctorNavbar;
