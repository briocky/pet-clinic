"use client";

import React, { useState } from "react";
import useUserAuth from "@/hook/useUserAuth";
import Link from "next/link";

type Appointment = {
    id: number;
    petName: string;
    doctorName: string;
    date: string;
    time: string;
    type: "upcoming" | "historical";
};

const appointments: Appointment[] = [
    {
        id: 1,
        petName: "Buddy",
        doctorName: "Dr. Smith",
        date: "2024-07-01",
        time: "10:00 AM",
        type: "upcoming",
    },
    {
        id: 2,
        petName: "Marry",
        doctorName: "Dr. Doe",
        date: "2023-07-20",
        time: "02:00 PM",
        type: "historical",
    },
    {
        id: 3,
        petName: "Max",
        doctorName: "Dr. Emily",
        date: "2024-07-21",
        time: "01:00 PM",
        type: "upcoming",
    },
    {
        id: 4,
        petName: "Max",
        doctorName: "Dr. Doe",
        date: "2023-05-20",
        time: "02:00 PM",
        type: "historical",
    },
    {
        id: 5,
        petName: "Selle",
        doctorName: "Dr. Martha",
        date: "2024-08-01",
        time: "09:00 AM",
        type: "upcoming",
    },
    // Add more appointments as needed
];

const AppointmentCard: React.FC<{ appointment: Appointment; onCancel: (id: number) => void }> = ({
                                                                                                     appointment,
                                                                                                     onCancel,
                                                                                                 }) => (
    <div className="border rounded-lg p-4 mb-4">
        <p className="font-semibold">
            <strong>Pet Name:</strong> {appointment.petName}
        </p>
        <p>
            <strong>Doctor:</strong> {appointment.doctorName}
        </p>
        <p>
            <strong>Date:</strong> {appointment.date}
        </p>
        <p>
            <strong>Time:</strong> {appointment.time}
        </p>
        {appointment.type === "upcoming" && (
            <div className="flex justify-end mt-4">
                <button className="bg-blue-500 text-white px-3 py-1 rounded-full mr-2">
                    View Invoice
                </button>
                <button
                    className="bg-red-500 text-white px-3 py-1 rounded-full"
                    onClick={() => onCancel(appointment.id)}
                >
                    Cancel
                </button>
            </div>
        )}
    </div>
);

const AllAppointments: React.FC = () => {
    const [activeTab, setActiveTab] = useState<"upcoming" | "historical">("upcoming");
    const filteredAppointments = appointments.filter((appointment) => appointment.type === activeTab);

    useUserAuth();

    const cancelAppointment = (id: number) => {
        // Implement cancellation logic here
        console.log("Appointment with ID", id, "canceled");
    };

    return (
        <div className="container mx-auto p-6">
            <h1 className="text-3xl font-bold mb-6 text-center">Appointments</h1>
            <div className="flex justify-between items-center mb-6">
                <div>
                    <button
                        className={`px-6 py-2 rounded-l-full transition-colors duration-300 ${
                            activeTab === "upcoming"
                                ? "bg-blue-600 text-white"
                                : "bg-gray-200 hover:bg-gray-300"
                        }`}
                        onClick={() => setActiveTab("upcoming")}
                    >
                        Upcoming Appointments
                    </button>
                    <button
                        className={`px-6 py-2 rounded-r-full transition-colors duration-300 ${
                            activeTab === "historical"
                                ? "bg-blue-600 text-white"
                                : "bg-gray-200 hover:bg-gray-300"
                        }`}
                        onClick={() => setActiveTab("historical")}
                    >
                        Historical Appointments
                    </button>
                </div>
                <Link href="/user/appointment/new">
                    <button className="px-6 py-2 bg-green-600 text-white rounded-full shadow-md hover:bg-green-700 transition-colors duration-300">
                        Order New Appointment
                    </button>
                </Link>
            </div>
            <div className="grid gap-4 md:grid-cols-2 lg:grid-cols-3">
                {filteredAppointments.length === 0 ? (
                    <p className="text-center text-gray-500">No appointments found.</p>
                ) : (
                    filteredAppointments.map((appointment) => (
                        <AppointmentCard
                            key={appointment.id}
                            appointment={appointment}
                            onCancel={cancelAppointment}
                        />
                    ))
                )}
            </div>
        </div>
    );
};

export default AllAppointments;
