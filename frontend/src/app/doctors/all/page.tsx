import React from 'react';
import Header from "@/components/header/Header";

const doctors = [
    {
        name: 'Dr. Sarah Johnson',
        specialization: 'Veterinary Surgeon',
        description: 'Dr. Sarah Johnson is our lead veterinary surgeon with over 10 years of experience. She specializes in surgical procedures and has a passion for orthopedic surgery.',
        imageUrl: 'https://media.istockphoto.com/id/1330046035/photo/headshot-portrait-of-smiling-female-doctor-in-hospital.jpg?s=612x612&w=0&k=20&c=fsNQPbmFIxoKA-PXl3G745zj7Cvr_cFIGsYknSbz_Tg=',
    },
    {
        name: 'Dr. Michael Smith',
        specialization: 'Internal Medicine Specialist',
        description: 'Dr. Michael Smith is an internal medicine specialist with extensive knowledge in diagnosing and treating complex medical conditions in pets. He is dedicated to providing compassionate care to all patients.',
        imageUrl: 'https://img.freepik.com/free-photo/doctor-offering-medical-teleconsultation_23-2149329007.jpg',
    },
    {
        name: 'Dr. Emily Williams',
        specialization: 'Dermatologist',
        description: 'Dr. Emily Williams is our dermatology expert, specializing in the diagnosis and treatment of skin conditions in animals. She is known for her meticulous approach and gentle demeanor.',
        imageUrl: 'https://www.shutterstock.com/image-photo/photo-sweet-confident-mature-lady-600nw-1918036262.jpg',
    },
    // Add more doctors as needed
];

const DoctorsAll: React.FC = () => {
    return (
        <>
            <Header />
            <div className="min-h-screen py-12">
                <div className="container mx-auto px-4">
                    <h1 className="text-4xl font-extrabold text-center text-gray-800 mb-12">
                        Meet Our Doctors
                    </h1>
                    <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-8">
                        {doctors.map((doctor, index) => (
                            <div key={index}
                                 className="bg-white p-6 rounded-lg shadow-lg hover:shadow-2xl transition-shadow duration-300">
                                <img
                                    src={doctor.imageUrl}
                                    alt={doctor.name}
                                    className="w-full h-48 object-cover rounded-t-lg"
                                />
                                <h2 className="text-2xl font-semibold mt-4 text-gray-800">{doctor.name}</h2>
                                <p className="text-gray-600 mt-2">{doctor.specialization}</p>
                                <p className="text-gray-700 mt-4">{doctor.description}</p>
                            </div>
                        ))}
                    </div>
                    <div className="mt-12 text-center">
                        <p className="text-lg text-gray-700">
                            Our team of experienced veterinarians is dedicated to providing
                            exceptional care for your pets. Whether it's a routine check-up or a
                            complex medical issue, you can trust our doctors to provide the highest
                            level of expertise and compassion.
                        </p>
                        <p className="text-lg text-gray-700 mt-4">
                            Contact us today to schedule an appointment and meet our wonderful team
                            in person.
                        </p>
                    </div>
                </div>
            </div>
        </>
    );
};

export default DoctorsAll;
