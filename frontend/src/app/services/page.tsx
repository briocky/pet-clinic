"use client";

import React from 'react';
import Header from "@/components/header/Header";

const services = [
    {
        title: 'Preventive Examinations',
        description: 'Regular health check-ups that help detect diseases early and ensure a long and healthy life for your pet.',
        imageUrl: 'https://cahtc.com/wp-content/uploads/2023/09/Comprehensive-Physical-Examinations.jpg',
    },
    {
        title: 'Vaccinations',
        description: 'We offer a full range of vaccinations for dogs, cats, and other pets to protect them from serious diseases.',
        imageUrl: 'https://smb.ibsrv.net/imageresizer/image/article_manager/1200x1200/24157/273480/heroimage0.842104001616020707.jpg',
    },
    {
        title: 'Laboratory Diagnostics',
        description: 'A modern diagnostic laboratory that allows for quick and accurate blood, urine, and other sample tests.',
        imageUrl: 'https://img.freepik.com/premium-photo/image-laboratory-tests-being-conducted-pet-s-sample_933496-11332.jpg',
    },
    {
        title: 'Surgery',
        description: 'We perform a wide range of surgical procedures, from routine spaying and neutering to more complex surgeries.',
        imageUrl: 'https://www.vetmed.com.au/wp-content/uploads/2018/02/golden-retriever-on-surgical-bench-min-1080x675.jpg',
    },
    {
        title: 'Dentistry',
        description: 'Comprehensive dental services, including teeth cleaning, extractions, and treatment of periodontal disease.',
        imageUrl: 'https://oldtowneah.com/files/2022/04/GettyImages-1324673228.jpg',
    },
    {
        title: 'Grooming',
        description: 'Professional grooming services, including baths, haircuts, nail trimming, and other grooming treatments.',
        imageUrl: 'https://cdn.shopify.com/s/files/1/0259/9626/3490/files/dog-grooming-1.png?v=1665519040',
    },
];

const Services: React.FC = () => {

    return (
        <>
            <Header/>
            <div className="min-h-screen py-12">
                <div className="container mx-auto px-4">
                    <h1 className="text-4xl font-extrabold text-center text-gray-800 mb-12">
                        Our Services
                    </h1>
                    <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-8">
                        {services.map((service, index) => (
                            <div key={index}
                                 className="bg-white p-6 rounded-lg shadow-lg hover:shadow-2xl transition-shadow duration-300">
                                <img
                                    src={service.imageUrl}
                                    alt={service.title}
                                    className="w-full h-48 object-cover rounded-t-lg"
                                />
                                <h2 className="text-2xl font-semibold mt-4 text-gray-800">{service.title}</h2>
                                <p className="text-gray-600 mt-2">{service.description}</p>
                            </div>
                        ))}
                    </div>
                    <div className="mt-12 text-center">
                        <p className="text-lg text-gray-700">
                            At our veterinary clinic, we are dedicated to providing the highest
                            quality care for your pets. Our experienced team is here to ensure that
                            your furry friends receive the best treatment possible.
                        </p>
                        <p className="text-lg text-gray-700 mt-4">
                            Contact us today to learn more about our services or to schedule an
                            appointment.
                        </p>
                    </div>
                </div>
            </div>
        </>
    );
};

export default Services;
