"use client";

import {useEffect} from 'react';
import {useSelector} from 'react-redux';
import {useRouter} from 'next/navigation';
import {RootState} from "@/redux/store";

const useUserAuth = () => {
    const router = useRouter();
    const {isLoggedIn, userDetails} = useSelector((state: RootState) => state.auth);

    useEffect(() => {
        if (!isLoggedIn || userDetails?.systemRole != 'USER') {
            router.push('/auth/login');
        }
    }, [router]);

    return {isLoggedIn, userDetails};
};

export default useUserAuth;