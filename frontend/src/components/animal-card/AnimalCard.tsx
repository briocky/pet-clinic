import React from 'react';

type AnimalCardProps = {
    name: string;
    species: string;
    age: number;
    imageUrl: string;
};

const AnimalCard: React.FC<AnimalCardProps> = ({ name, species, age, imageUrl }) => {
    return (
        <div className="bg-white shadow-md rounded-lg overflow-hidden">
            <img src={imageUrl} alt={name} className="w-full h-48 object-cover" />
            <div className="p-4">
                <h3 className="text-xl font-semibold">{name}</h3>
                <p className="text-gray-600">{species}</p>
                <p className="text-gray-600">{age} years old</p>
            </div>
        </div>
    );
};

export default AnimalCard;
