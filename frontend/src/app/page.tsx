"use client";

import React from 'react';
import Header from '@/components/header/Header';
import HeroSection from '@/components/hero-section/HeroSection';
import Footer from '@/components/footer/Footer';
import ServiceSection from "@/components/services/ServiceSection";
import ReduxProvider from "@/redux/ReduxProvider";

const Home: React.FC = () => {
  return (
      <ReduxProvider>
        <Header />
        <HeroSection />
        <ServiceSection />
        <Footer />
      </ReduxProvider>
  );
};

export default Home;