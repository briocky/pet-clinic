"use client";

import React from 'react';
import Header from '@/components/header/Header';
import HeroSection from '@/components/hero-section/HeroSection';
import Footer from '@/components/footer/Footer';
import ServiceSection from "@/components/services/ServiceSection";

const Home: React.FC = () => {
    return (
        <>
            <Header/>
            <HeroSection/>
            <ServiceSection/>
            <Footer/>
        </>
    );
};

export default Home;