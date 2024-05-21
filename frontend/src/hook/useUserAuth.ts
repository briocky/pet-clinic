import { useEffect } from 'react';
import { useSelector } from 'react-redux';
import { useRouter } from 'next/navigation';
import { RootState } from '@/redux/store';

const useUserAuth = () => {
  const router = useRouter();
  const { isLoggedIn, user } = useSelector((state: RootState) => state.auth);

  useEffect(() => {
    if (!isLoggedIn || user?.role !== 'USER') {
      router.push('/auth/login');
    }
  }, [isLoggedIn, user, router]);

  return { isLoggedIn, user };
};

export default useUserAuth;