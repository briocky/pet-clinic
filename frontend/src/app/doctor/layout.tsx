"use client";

import React from "react";
import DoctorNavbar from "@/components/navbar/DoctorNavbar";

export default function AppointmentLayout(
    {children}: Readonly<{ children: React.ReactNode; }>
) {
    return (
        <>
            <DoctorNavbar/>
            {children}
        </>
    );
}