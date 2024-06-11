"use client";

import React, { useState } from 'react';
import Head from 'next/head';

type AnimalAppointment = {
    id: number;
    name: string;
    species: string;
    appointmentTime: string;
};

const initialAppointments: AnimalAppointment[] = [
    {
        id: 1,
        name: 'Rex',
        species: 'Dog',
        appointmentTime: '2024-06-10T10:00:00',
    },
    {
        id: 2,
        name: 'Whiskers',
        species: 'Cat',
        appointmentTime: '2024-06-12T14:00:00',
    },
    // Add more sample appointments
];

const AllAppointments: React.FC = () => {
    const [appointments, setAppointments] = useState<AnimalAppointment[]>(initialAppointments);

    const cancelAppointment = (id: number) => {
        setAppointments(prevAppointments => prevAppointments.filter(appointment => appointment.id !== id));
    };

    return (
        <div className="container mx-auto mt-8">
            <Head>
                <title>Upcoming Animal Appointments</title>
                <link rel="icon" href="/favicon.ico" />
            </Head>

            <main>
                <h1 className="text-3xl font-bold mb-4">Upcoming Animal Appointments</h1>
                <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4">
                    {appointments.map(appointment => (
                        <div key={appointment.id} className="border border-gray-200 rounded-md p-4">
                            <h2 className="text-xl font-bold">{appointment.name}</h2>
                            <p>Species: {appointment.species}</p>
                            <p>Appointment Time: {new Date(appointment.appointmentTime).toLocaleString()}</p>
                            <button
                                onClick={() => cancelAppointment(appointment.id)}
                                className="mt-2 bg-red-500 hover:bg-red-600 text-white font-bold py-2 px-4 rounded"
                            >
                                Cancel
                            </button>
                        </div>
                    ))}
                </div>
            </main>
        </div>
    );
};

export default AllAppointments;
