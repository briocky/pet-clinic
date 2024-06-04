import React, { useState } from 'react';
import {useRouter} from "next/navigation";
import {useDispatch, useSelector} from "react-redux";
import {RootState} from "@/redux/store";
import {logout} from "@/redux/slices/authSlice";
import {deleteToken} from "@/service/token.service";
import Image from "next/image";

const UserAvatar = () => {
    const [isOpen, setIsOpen] = useState(false);
    const router = useRouter();
    const dispatch = useDispatch();
    const {isLoggedIn, userDetails} = useSelector((state: RootState) => state.auth);

    const handleLogout = () => {
        dispatch(logout());
        deleteToken();
        router.push('/');
    }

    const toggleDropdown = () => {
        setIsOpen(!isOpen);
    };

    return (
        <div className="relative inline-block text-left">
            <div>
                <button
                    type="button"
                    onClick={toggleDropdown}
                    className="flex items-center text-sm rounded-full focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
                >
                    <Image
                        width={55} height={55}
                        className="rounded-full"
                        src="/images/profile_picture.jpg"
                        alt="User Avatar"
                    />
                </button>
            </div>

            {isOpen && (
                <div className="origin-top-right absolute right-0 mt-2 w-48 rounded-md shadow-lg bg-white ring-1 ring-black ring-opacity-5 focus:outline-none z-20">
                    <div className="py-1" role="menu" aria-orientation="vertical" aria-labelledby="options-menu">
                        <a
                            href="/settings"
                            className="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100"
                            role="menuitem"
                        >
                            Settings
                        </a>
                        <a
                            onClick={handleLogout}
                            className="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100"
                            role="menuitem"
                        >
                            Logout
                        </a>
                    </div>
                </div>
            )}
        </div>
    );
};

export default UserAvatar;
