"use client"

import React, { useState } from 'react';
import Head from 'next/head';

type AppointmentSlot = {
    id: number;
    date: string;
    startTime: string;
    endTime: string;
    available: boolean;
};

const Calendar: React.FC = () => {
    const [slots, setSlots] = useState<AppointmentSlot[]>([]);
    const [date, setDate] = useState('');
    const [startTime, setStartTime] = useState('');
    const [endTime, setEndTime] = useState('');
    const [selectedDate, setSelectedDate] = useState('');

    const addSlot = () => {
        if (!date || !startTime || !endTime) {
            alert('Please fill out all fields');
            return;
        }

        const newSlot: AppointmentSlot = {
            id: slots.length + 1,
            date,
            startTime,
            endTime,
            available: true,
        };
        setSlots([...slots, newSlot]);
        setDate('');
        setStartTime('');
        setEndTime('');
    };

    const toggleAvailability = (id: number) => {
        setSlots(prevSlots =>
            prevSlots.map(slot =>
                slot.id === id ? { ...slot, available: !slot.available } : slot
            )
        );
    };

    const getSlotsByDate = (date: string) => {
        return slots.filter(slot => slot.date === date);
    };

    const slotsForSelectedDate = getSlotsByDate(selectedDate);

    return (
        <div className="container mx-auto my-8">
            <Head>
                <title>Doctor's Calendar</title>
                <link rel="icon" href="/favicon.ico" />
            </Head>

            <main>
                <h1 className="text-3xl font-bold mb-4">Doctor's Calendar</h1>

                <div className="mb-4">
                    <h2 className="text-2xl font-bold mb-2">Add New Slot</h2>
                    <div className="mb-2">
                        <label className="block text-sm font-medium text-gray-700">
                            Date
                            <input
                                type="date"
                                value={date}
                                onChange={e => setDate(e.target.value)}
                                className="mt-1 block w-full p-2 border border-gray-300 rounded-md"
                            />
                        </label>
                    </div>
                    <div className="mb-2">
                        <label className="block text-sm font-medium text-gray-700">
                            Start Time
                            <input
                                type="time"
                                value={startTime}
                                onChange={e => setStartTime(e.target.value)}
                                className="mt-1 block w-full p-2 border border-gray-300 rounded-md"
                            />
                        </label>
                    </div>
                    <div className="mb-2">
                        <label className="block text-sm font-medium text-gray-700">
                            End Time
                            <input
                                type="time"
                                value={endTime}
                                onChange={e => setEndTime(e.target.value)}
                                className="mt-1 block w-full p-2 border border-gray-300 rounded-md"
                            />
                        </label>
                    </div>
                    <button
                        onClick={addSlot}
                        className="mt-2 bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded"
                    >
                        Add Slot
                    </button>
                </div>

                <div className="mb-4">
                    <h2 className="text-2xl font-bold mb-2">View Slots by Date</h2>
                    <div className="mb-2">
                        <label className="block text-sm font-medium text-gray-700">
                            Select Date
                            <input
                                type="date"
                                value={selectedDate}
                                onChange={e => setSelectedDate(e.target.value)}
                                className="mt-1 block w-full p-2 border border-gray-300 rounded-md"
                            />
                        </label>
                    </div>
                </div>

                {selectedDate && (
                    <div>
                        <h2 className="text-2xl font-bold mb-2">
                            Slots for {selectedDate}
                        </h2>
                        {slotsForSelectedDate.length > 0 ? (
                            <table className="table-auto w-full">
                                <thead>
                                <tr>
                                    <th className="border px-4 py-2">Start Time</th>
                                    <th className="border px-4 py-2">End Time</th>
                                    <th className="border px-4 py-2">Available</th>
                                    <th className="border px-4 py-2">Toggle Availability</th>
                                </tr>
                                </thead>
                                <tbody>
                                {slotsForSelectedDate.map(slot => (
                                    <tr key={slot.id}>
                                        <td className="border px-4 py-2">{slot.startTime}</td>
                                        <td className="border px-4 py-2">{slot.endTime}</td>
                                        <td className="border px-4 py-2">{slot.available ? 'Yes' : 'No'}</td>
                                        <td className="border px-4 py-2">
                                            <button
                                                onClick={() => toggleAvailability(slot.id)}
                                                className={`p-2 rounded-md ${
                                                    slot.available ? 'bg-green-500 text-white' : 'bg-red-500 text-white'
                                                }`}
                                            >
                                                {slot.available ? 'Available' : 'Booked'}
                                            </button>
                                        </td>
                                    </tr>
                                ))}
                                </tbody>
                            </table>
                        ) : (
                            <p>No slots available for this date.</p>
                        )}
                    </div>
                )}
            </main>
        </div>
    );
};

export default Calendar;
