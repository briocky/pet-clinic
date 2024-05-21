import React from 'react';
import Link from "next/link";

interface ServiceCardProps {
  title: string;
  description: string;
  link: string;
}

const ServiceCard: React.FC<ServiceCardProps> = ({ title, description, link }) => {
  return (
      <div className="bg-white p-6 rounded-lg shadow-lg text-center">
        <h3 className="text-xl font-bold mb-2">{title}</h3>
        <p className="mb-4">{description}</p>
        <Link href={link} className="text-blue-500 hover:underline">Read More</Link>
      </div>
  );
};

export default ServiceCard;
