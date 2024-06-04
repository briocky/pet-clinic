"use client";

import React from "react";
import useUserAuth from "@/hook/useUserAuth";

const AllAppointments: React.FC = () => {
    useUserAuth();

    return (
        <>
            Protected doctor all appointments
        </>
    );
};

export default AllAppointments;