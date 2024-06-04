import React from 'react';
import Header from "@/components/header/Header";

const AboutUs: React.FC = () => {
    return (
        <>
            <Header/>
            <div className="min-h-screen py-12">
                <div className="container mx-auto px-4">
                    <h1 className="text-4xl font-extrabold text-gray-800 mb-8">About Us</h1>
                    <div className="grid grid-cols-1 md:grid-cols-2 gap-12">
                        <div>
                            <img
                                src="https://impeccabuild.com.au/wp-content/uploads/2022/10/Vet-Clinic-Ideas-1-1024x683.jpg"
                                alt="About Us" className="w-full h-auto rounded-lg shadow-lg"/>
                        </div>
                        <div>
                            <h2 className="text-2xl font-semibold mb-4">Our Story</h2>
                            <p className="text-gray-700 leading-relaxed">
                                Our clinic was founded with a passion for animals and a vision to
                                prioritize both medical excellence and compassionate care. Over the
                                years, we've built lasting relationships with our clients and their
                                pets, supporting them through every stage of their journey. From a
                                small
                                clinic to a thriving practice, we've grown while staying true to our
                                core values of compassion and integrity.
                            </p>
                            <h2 className="text-2xl font-semibold mt-8 mb-4">Our Mission</h2>
                            <p className="text-gray-700 leading-relaxed">
                                We're dedicated to providing compassionate veterinary care for every
                                pet, prioritizing their health and wellbeing. Our mission is to
                                promote
                                pet health through preventive care, education, and advanced medical
                                treatments. We're committed to exceptional client-centered service,
                                ensuring pet owners feel supported and informed. We actively engage
                                with
                                our community through outreach programs and partnerships, giving
                                back to
                                those who trust us with their pets' care. We strive for continuous
                                improvement, staying updated on the latest advancements to provide
                                the
                                highest quality care.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
};

export default AboutUs;
