import React from 'react';
import AnimalCard from '@/components/animal-card/AnimalCard';
import {animals} from "@/app/user/pets/all/data";
import Link from 'next/link';

const AllPets: React.FC = () => {
    return (
        <div className="container mt-6 mx-auto p-4">
            <div className="flex justify-between items-center mb-8">
                <h1 className="text-3xl font-bold">Your Animals</h1>
                <Link href="/user/pets/register-new" className="bg-blue-500 text-white px-4 py-2 rounded-lg hover:bg-blue-700">
                    Register new pet
                </Link>
            </div>
            <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-4">
                {animals.map((animal, index) => (
                    <AnimalCard key={index} {...animal} />
                ))}
            </div>
        </div>
    );
};

export default AllPets;
