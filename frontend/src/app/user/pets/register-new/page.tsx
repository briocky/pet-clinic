"use client";

import React, { useState } from 'react';
import Link from 'next/link';

const RegisterNewPet: React.FC = () => {
    const [formData, setFormData] = useState({
        name: '',
        species: '',
        breed: '',
        birthDate: '',
    });

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };

    const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        console.log(formData);
    };

    return (
        <div className="flex items-center justify-center min-h-screen">
            <div className="bg-white p-6 rounded-lg shadow-lg w-full max-w-md">
                <h1 className="text-2xl font-bold mb-6 text-center">Register a pet</h1>
                <form className="space-y-4" onSubmit={handleSubmit}>
                    <div>
                        <label htmlFor="name" className="block text-sm font-medium text-gray-700">
                            Pet's name
                        </label>
                        <input
                            type="text"
                            id="name"
                            name="name"
                            value={formData.name}
                            onChange={handleChange}
                            className="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-blue-500 focus:border-blue-500 sm:text-sm"
                        />
                    </div>
                    <div>
                        <label htmlFor="species" className="block text-sm font-medium text-gray-700">
                            Species
                        </label>
                        <input
                            type="text"
                            id="species"
                            name="species"
                            value={formData.species}
                            onChange={handleChange}
                            className="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-blue-500 focus:border-blue-500 sm:text-sm"
                        />
                    </div>
                    <div>
                        <label htmlFor="breed" className="block text-sm font-medium text-gray-700">
                            Breed
                        </label>
                        <input
                            type="text"
                            id="breed"
                            name="breed"
                            value={formData.breed}
                            onChange={handleChange}
                            className="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-blue-500 focus:border-blue-500 sm:text-sm"
                        />
                    </div>
                    <div>
                        <label htmlFor="birthDate" className="block text-sm font-medium text-gray-700">
                            Birth date
                        </label>
                        <input
                            type="date"
                            id="birthDate"
                            name="birthDate"
                            value={formData.birthDate}
                            onChange={handleChange}
                            className="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-blue-500 focus:border-blue-500 sm:text-sm"
                        />
                    </div>
                    <div className="flex justify-between items-center">
                        <button
                            type="submit"
                            className="bg-blue-500 text-white px-4 py-2 rounded-lg hover:bg-blue-700"
                        >
                            Register
                        </button>
                        <Link href="/" className="text-blue-500 hover:underline">
                            Cancel
                        </Link>
                    </div>
                </form>
            </div>
        </div>
    );
};

export default RegisterNewPet;
