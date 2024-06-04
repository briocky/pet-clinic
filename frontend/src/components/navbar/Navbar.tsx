"use client";

import React from 'react';
import Link from 'next/link';
import {useRouter} from "next/navigation";
import Image from "next/image";
import UserAvatar from "@/components/user-avatar/UserAvatar";

const Navbar = () => {
    const router = useRouter();

    return (
        <header className="flex justify-between items-center px-10 pt-10">
            <Image width={200} height={200} src={'/images/logo.svg'} alt={'logo'}/>
            <nav className="space-x-10 rounded-3xl bg-white drop-shadow-2xl py-3 px-12">
                <Link href="/user/appointment/all" className="hover:underline">
                    Appointments
                </Link>
                <Link href="/services" className="hover:underline">
                    Services
                </Link>
                <Link href="/user/pets/all" className="hover:underline">
                    Pets
                </Link>
                <Link href="/doctors/all" className="hover:underline">
                    Doctors
                </Link>
                <Link href="/contacts" className="hover:underline">
                    Contacts
                </Link>
            </nav>
            <div className={'text-sm text-right text-gray-700'}>
                <UserAvatar/>
            </div>
        </header>
    );
};

export default Navbar;
