import React from 'react';
import Header from "@/components/header/Header";

const Contacts: React.FC = () => {
    return (
        <>
            <Header/>
            <div className="min-h-screen py-12">
                <div className="container mx-auto px-4">
                    <div className="grid grid-cols-1 md:grid-cols-2 gap-12">
                        <div>
                            <h1 className="text-4xl font-extrabold text-gray-800 mb-8">Contact
                                Us</h1>
                            <div className="bg-white p-6 rounded-lg shadow-lg">
                                <h2 className="text-2xl font-semibold mb-4">Visit Us</h2>
                                <p className="text-gray-600 mb-2">Częstochowska 20</p>
                                <p className="text-gray-600 mb-2">02-344 Warszawa</p>
                                <p className="text-gray-600 mb-2">Poland</p>
                                <p className="text-gray-600 mb-2">Opening Hours: 12:00 - 21:00 everyday!</p>
                            </div>
                            <div className="mt-8 bg-white p-6 rounded-lg shadow-lg">
                                <h2 className="text-2xl font-semibold mb-4">Contact Information</h2>
                                <p className="text-gray-600 mb-2">Phone: +48 573 381 921</p>
                                <p className="text-gray-600 mb-2">Email: info@vetexpert.pl</p>
                            </div>
                        </div>
                        <div>
                            <div className="bg-white p-6 rounded-lg shadow-lg">
                                <h2 className="text-2xl font-semibold mb-4">Find Us</h2>
                                <div className="h-80 rounded-lg overflow-hidden">
                                    {/* Insert map component or embed map iframe here */}
                                    <img src="https://img.freepik.com/premium-vector/map-with-destination-location-point-city-map-with-street-river-gps-map-navigator-concept_34645-1078.jpg"
                                         alt="Map" className="w-full h-full object-cover"/>
                                </div>
                            </div>
                            <div className="mt-8 bg-white p-6 rounded-lg shadow-lg">
                                <h2 className="text-2xl font-semibold mb-4">Send Us a Message</h2>
                                <form>
                                    <div className="mb-4">
                                        <label htmlFor="name"
                                               className="block text-gray-700 font-medium mb-2">Your
                                            Name</label>
                                        <input type="text" id="name" name="name"
                                               className="w-full px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:border-blue-500"/>
                                    </div>
                                    <div className="mb-4">
                                        <label htmlFor="email"
                                               className="block text-gray-700 font-medium mb-2">Your
                                            Email</label>
                                        <input type="email" id="email" name="email"
                                               className="w-full px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:border-blue-500"/>
                                    </div>
                                    <div className="mb-4">
                                        <label htmlFor="message"
                                               className="block text-gray-700 font-medium mb-2">Message</label>
                                        <textarea id="message" name="message" rows={4}
                                                  className="w-full px-4 py-2 border border-gray-300 rounded-md resize-none focus:outline-none focus:border-blue-500"></textarea>
                                    </div>
                                    <div>
                                        <button type="submit"
                                                className="bg-blue-500 text-white px-4 py-2 rounded-md hover:bg-blue-700">Send
                                            Message
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
};

export default Contacts;
