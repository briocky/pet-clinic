import React from "react";
import Image from 'next/image';
import Link from "next/link";

interface Props {
}

const HeroSection: React.FC<Props> = () => {
  return (
      <section className="flex flex-row px-36 py-20 gap-10">
        <div className="flex flex-col my-auto h-full space-y-7">
          <div className="flex flex-col justify-center space-y-10">
            <h1 className="text-4xl font-bold">Caring for your furry 🐈 friends</h1>
            <p className="text-base ps-1 pe-20">We provide comprehensive veterinary care services.
              The leading clinic in Warsaw, top specialist, modern technology, proven medicines.</p>
          </div>
          <div>
            <button className="bg-yellow-500 text-sm font-medium py-2 px-4 rounded-3xl">
              <Link href={'/appointment/new'}> Book Now </Link>
            </button>
          </div>
        </div>
        <Image
            src="/images/cat-minified.png"
            width={520} height={520}
            alt="Happy Paw Vet Clinic"
            className="object-cover"
        />
      </section>
  );
};

export default HeroSection;
