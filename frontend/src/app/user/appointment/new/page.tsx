"use client";

import {useEffect, useState} from 'react';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import useUserAuth from "@/hook/useUserAuth";
import {
    getAvailableDoctors,
    getDoctorAvailableAppointmentDays,
    getDoctorAvailableAppointmentHourSlots, getPets
} from "@/service/owner.service";
import {AppointmentSlot, Doctor} from "@/entities/doctor/Doctor.types";
import {PatientDto} from "@/entities/patient/Patient.types";

type Pet = {
    id: number;
    name: string;
};

const pets: Pet[] = [
    {id: 1, name: 'Buddy'},
    {id: 2, name: 'Max'},
    {id: 3, name: 'Bella'},
    // Add more pets as needed
];


const NewAppointment = () => {
    useUserAuth();
    const [selectedPet, setSelectedPet] = useState<Pet | null>(null);
    const [selectedDoctor, setSelectedDoctor] = useState<Doctor | null>(null);
    const [availableDoctors, setAvailableDoctors] = useState<Doctor[]>([]);
    const [availableDays, setAvailableDays] = useState<AppointmentSlot[]>([]);
    const [appointmentDate, setAppointmentDate] = useState<AppointmentSlot | null>(null);
    const [availableSlots, setAvailableSlots] = useState<AppointmentSlot[]>([]);
    const [selectedSlot, setSelectedSlot] = useState<AppointmentSlot | null>(null);
    const [purpose, setPurpose] = useState<string>('');
    const [pets, setPets] = useState<PatientDto[]>([]);

    const setSlot = (date: Date) => {
        setAppointmentDate(
            availableDays.filter(availableDay => new Date(availableDay.date).toDateString() == date.toDateString())[0]
        )
    }

    useEffect(() => {
        getPets().then(
            pets => {
                setPets(pets);
            }
        )
    }, []);

    useEffect(() => {
        getAvailableDoctors().then(
            doctors => {
                setAvailableDoctors(doctors);
            }
        )
    }, []);

    useEffect(() => {
        if (!selectedDoctor) return;

        getDoctorAvailableAppointmentDays(selectedDoctor.id).then(
            availableDays => {
                setAvailableDays(availableDays);
            }
        )
    }, [selectedDoctor]);

    useEffect(() => {
        if (!selectedDoctor || !appointmentDate) return;
        getDoctorAvailableAppointmentHourSlots(selectedDoctor.id, appointmentDate.date).then(
            availableSlots => {
                setAvailableSlots(availableSlots);
            }
        )
    }, [selectedDoctor, appointmentDate]);

    const handleSubmit = () => {
        if (selectedPet && selectedDoctor && selectedSlot && purpose) {
            // Handle appointment submission
            console.log('Appointment booked for', selectedPet.name, 'with', selectedDoctor.userDetailsDto.firstName + " " + selectedDoctor.userDetailsDto.lastName, 'on', selectedSlot.date, 'at', selectedSlot.timeFrom, 'for', purpose);
            console.log()
        } else {
            console.log('Please complete all fields');
        }
    };

    return (
        <div className="container mx-auto p-6">
            <h1 className="text-3xl font-bold mb-6 text-center">Order New Appointment</h1>
            <div className="bg-white p-6 rounded-lg shadow-lg max-w-md mx-auto">
                <div className="mb-4">
                    <label className="block text-gray-700 mb-2" htmlFor="pet">
                        Select Pet
                    </label>
                    <select
                        id="pet"
                        className="w-full p-2 border rounded"
                        value={selectedPet?.id || ''}
                        onChange={(e) => setSelectedPet(pets.find(pet => pet.id === Number(e.target.value)) || null)}
                    >
                        <option value="">Select a pet</option>
                        {pets.map(pet => (
                            <option key={pet.id} value={pet.id}>{pet.name}</option>
                        ))}
                    </select>
                </div>
                <div className="mb-4">
                    <label className="block text-gray-700 mb-2" htmlFor="doctor">
                        Select Doctor
                    </label>
                    <select
                        id="doctor"
                        className="w-full p-2 border rounded"
                        value={selectedDoctor?.id || ''}
                        onChange={(e) => setSelectedDoctor(availableDoctors.find(doctor => doctor.id === Number(e.target.value)) || null)}
                    >
                        <option value="">Select a doctor</option>
                        {availableDoctors.map(doctor => (
                            <option key={doctor.id}
                                    value={doctor.id}>{"Dr. " + doctor.userDetailsDto.firstName + doctor.userDetailsDto.lastName + " | " + doctor.specialization}</option>
                        ))}
                    </select>
                </div>
                {selectedDoctor && (
                    <div className="mb-4">
                        <label className="block text-gray-700 mb-2" htmlFor="date">
                            Select Date
                        </label>
                        <DatePicker
                            selected={appointmentDate?.date}
                            onChange={date => {
                                if (date) setSlot(date)
                            }}
                            className="w-full p-2 border rounded"
                            dateFormat="yyyy-MM-dd"
                            placeholderText="Select a date"
                            includeDates={availableDays.map(value => value.date)}
                        />
                    </div>
                )}
                {appointmentDate && (
                    <div className="mb-4">
                        <label className="block text-gray-700 mb-2" htmlFor="slot">
                            Select Time Slot
                        </label>
                        <select
                            id="slot"
                            className="w-full p-2 border rounded"
                            value={selectedSlot ? selectedSlot.id : ''}
                            onChange={(e) => {
                                const slot = availableSlots.find(slot => slot.id == Number(e.target.value));
                                setSelectedSlot(slot || null);
                            }}
                        >
                            <option value="">Select a time slot</option>
                            {availableSlots.map(slot => (
                                <option key={slot.id}
                                        value={slot.id}>
                                    {slot.timeFrom.toString()} to {slot.timeTo.toString()}
                                </option>
                            ))}
                        </select>
                    </div>
                )}
                <div className="mb-4">
                    <label className="block text-gray-700 mb-2" htmlFor="purpose">
                        Purpose of Appointment
                    </label>
                    <input
                        id="purpose"
                        className="w-full p-2 border rounded"
                        type="text"
                        value={purpose}
                        onChange={(e) => setPurpose(e.target.value)}
                        placeholder="Enter the purpose of the appointment"
                    />
                </div>
                <button
                    className="w-full px-4 py-2 bg-blue-600 text-white rounded shadow-md hover:bg-blue-700 transition-colors duration-300"
                    onClick={handleSubmit}
                >
                    Book Appointment
                </button>
            </div>
        </div>
    );
};

export default NewAppointment;
