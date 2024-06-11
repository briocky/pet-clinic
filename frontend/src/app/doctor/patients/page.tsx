"use client";

import React from 'react';
import Head from 'next/head';

type Animal = {
    id: number;
    name: string;
    species: string;
    imageUrl: string;
};

const initialAnimals: Animal[] = [
    {
        id: 1,
        name: 'Rex',
        species: 'Dog',
        imageUrl: 'https://www.hartz.com/wp-content/uploads/2022/04/small-dog-owners-1.jpg',
    },
    {
        id: 2,
        name: 'Whiskers',
        species: 'Cat',
        imageUrl: 'https://www.alleycat.org/wp-content/uploads/2019/03/FELV-cat.jpg',
    },
    {
        id: 3,
        name: 'Sammy',
        species: 'Cat',
        imageUrl: 'https://bestfriends.org/sites/default/files/styles/hero_mobile/public/hero-dash/Asana3808_Dashboard_Standard.jpg?h=ebad9ecf&itok=cWevo33k',
    },
    // Add more sample animals
];

const Patients: React.FC = () => {
    return (
        <div className="container mx-auto mt-8">
            <Head>
                <title>Our Patients</title>
                <link rel="icon" href="/favicon.ico" />
            </Head>

            <main>
                <h1 className="text-3xl font-bold mb-4">Our Patients</h1>
                <div className="mb-4">
                    {/* Symulacja paska wyszukiwania */}
                    <input
                        type="text"
                        placeholder="Search..."
                        className="border border-gray-300 p-2 rounded-md focus:outline-none focus:border-blue-500"
                    />
                </div>
                <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4">
                    {initialAnimals.map(animal => (
                        <div key={animal.id} className="border border-gray-200 rounded-md p-4 flex flex-col items-center">
                            <img
                                src={animal.imageUrl}
                                alt={animal.name}
                                className="w-64 h-32 object-cover rounded-md mb-2"
                            />
                            <h2 className="text-xl font-bold">{animal.name}</h2>
                            <p>Species: {animal.species}</p>
                        </div>
                    ))}
                </div>
            </main>
        </div>
    );
};

export default Patients;
