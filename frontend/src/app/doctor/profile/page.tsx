"use client"

import React, { useState } from 'react';
import Head from 'next/head';

const Profile: React.FC = () => {
    const [firstName, setFirstName] = useState('Michael');
    const [lastName, setLastName] = useState('Smith');
    const [email, setEmail] = useState('michael.smith@example.com');
    const [specialization, setSpecialization] = useState('Veterinary Surgeon');
    const [phone, setPhone] = useState('123-456-7890');
    const [isEditing, setIsEditing] = useState(false);
    const [profilePicture, setProfilePicture] = useState('https://img.freepik.com/free-photo/doctor-offering-medical-teleconsultation_23-2149329007.jpg'); // Default mock image

    const handleSave = () => {
        // Tu można dodać logikę zapisywania danych
        setIsEditing(false);
        alert('Profile updated successfully!');
    };

    const handleImageChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        if (e.target.files && e.target.files[0]) {
            const reader = new FileReader();
            reader.onload = () => {
                if (reader.readyState === 2) {
                    setProfilePicture(reader.result as string);
                }
            };
            reader.readAsDataURL(e.target.files[0]);
        }
    };

    return (
        <div className="container mx-auto mt-8">
            <Head>
                <title>Doctor's Profile</title>
                <link rel="icon" href="/favicon.ico" />
            </Head>

            <main>
                <h1 className="text-3xl font-bold mb-4">Doctor's Profile</h1>

                <div className="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4 flex">
                    <div className="w-3/4 pr-4">
                        {isEditing ? (
                            <>
                                <div className="mb-4">
                                    <label className="block text-gray-700 text-sm font-bold mb-2">
                                        First Name
                                        <input
                                            type="text"
                                            value={firstName}
                                            onChange={e => setFirstName(e.target.value)}
                                            className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                                        />
                                    </label>
                                </div>
                                <div className="mb-4">
                                    <label className="block text-gray-700 text-sm font-bold mb-2">
                                        Last Name
                                        <input
                                            type="text"
                                            value={lastName}
                                            onChange={e => setLastName(e.target.value)}
                                            className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                                        />
                                    </label>
                                </div>
                                <div className="mb-4">
                                    <label className="block text-gray-700 text-sm font-bold mb-2">
                                        Email
                                        <input
                                            type="email"
                                            value={email}
                                            onChange={e => setEmail(e.target.value)}
                                            className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                                        />
                                    </label>
                                </div>
                                <div className="mb-4">
                                    <label className="block text-gray-700 text-sm font-bold mb-2">
                                        Specialization
                                        <input
                                            type="text"
                                            value={specialization}
                                            onChange={e => setSpecialization(e.target.value)}
                                            className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                                        />
                                    </label>
                                </div>
                                <div className="mb-4">
                                    <label className="block text-gray-700 text-sm font-bold mb-2">
                                        Phone
                                        <input
                                            type="text"
                                            value={phone}
                                            onChange={e => setPhone(e.target.value)}
                                            className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                                        />
                                    </label>
                                </div>
                                <div className="flex items-center justify-between">
                                    <button
                                        onClick={handleSave}
                                        className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
                                    >
                                        Save
                                    </button>
                                    <button
                                        onClick={() => setIsEditing(false)}
                                        className="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
                                    >
                                        Cancel
                                    </button>
                                </div>
                            </>
                        ) : (
                            <>
                                <div className="mb-4">
                                    <p className="text-gray-700 text-sm font-bold mb-2">First Name</p>
                                    <p className="text-gray-700 text-lg">{firstName}</p>
                                </div>
                                <div className="mb-4">
                                    <p className="text-gray-700 text-sm font-bold mb-2">Last Name</p>
                                    <p className="text-gray-700 text-lg">{lastName}</p>
                                </div>
                                <div className="mb-4">
                                    <p className="text-gray-700 text-sm font-bold mb-2">Email</p>
                                    <p className="text-gray-700 text-lg">{email}</p>
                                </div>
                                <div className="mb-4">
                                    <p className="text-gray-700 text-sm font-bold mb-2">Specialization</p>
                                    <p className="text-gray-700 text-lg">{specialization}</p>
                                </div>
                                <div className="mb-4">
                                    <p className="text-gray-700 text-sm font-bold mb-2">Phone</p>
                                    <p className="text-gray-700 text-lg">{phone}</p>
                                </div>
                                <button
                                    onClick={() => setIsEditing(true)}
                                    className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
                                >
                                    Edit Profile
                                </button>
                            </>
                        )}
                    </div>
                    <div className="w-1/4 pl-4 flex flex-col items-center">
                        <img
                            src={profilePicture}
                            alt="Profile Picture"
                            className="rounded-full h-40 w-40 object-cover mb-4"
                        />
                        {isEditing && (
                            <>
                                <label className="block text-gray-700 text-sm font-bold mb-2">
                                    Change Profile Picture
                                    <input
                                        type="file"
                                        accept="image/*"
                                        onChange={handleImageChange}
                                        className="mt-1 block w-full text-sm text-gray-500
                               file:mr-4 file:py-2 file:px-4
                               file:rounded-full file:border-0
                               file:text-sm file:font-semibold
                               file:bg-blue-50 file:text-blue-700
                               hover:file:bg-blue-100"
                                    />
                                </label>
                            </>
                        )}
                    </div>
                </div>
            </main>
        </div>
    );
};

export default Profile;
