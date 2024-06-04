"use client";

import React from "react";
import Navbar from "@/components/navbar/Navbar";

export default function AppointmentLayout(
    {children}: Readonly<{ children: React.ReactNode; }>
) {
    return (
        <>
            <Navbar/>
            {children}
        </>
    );
}