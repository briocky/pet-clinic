import React from "react";
import Image from "next/image";
import Link from "next/link";

interface Props {}

const Header: React.FC<Props> = () => {
  return (
      <header className="flex justify-between items-center px-10 pt-10">
        <Link href={'/'}>
            <Image width={200} height={200} src={'/images/logo.svg'} alt={'logo'} />
        </Link>
        <nav className="space-x-10 rounded-3xl bg-white drop-shadow-2xl py-3 px-12">
          <Link href="/about-us" className="hover:underline">
            About Us
          </Link>
          <Link href="/services" className="hover:underline">
            Services
          </Link>
          <Link href="/reviews" className="hover:underline">
            Reviews
          </Link>
          <Link href="contacts" className="hover:underline">
            Contacts
          </Link>
          <button className="bg-yellow-500 text-sm font-medium py-2 px-4 rounded-3xl">
            <Link href={'/user/appointment/new'}> Book Now </Link>
          </button>
        </nav>
        <div className={'text-sm text-right text-gray-700'}>
          <p>Częstochowska 20, 02-344 Warszawa</p>
          <p>+48 573 381 921</p>
          <p>12:00 - 21:00 everyday!</p>
        </div>
      </header>
  );
};

export default Header;
