'use client';

import { useEffect, useState } from 'react';
import Link from 'next/link';
import { LogIn } from 'lucide-react';
import LogoutButton from "@/components/LogoutButton";

type UserInfo = {
    name: string;
    preferred_username: string;
};

export default function Header() {
    const [user, setUser] = useState<UserInfo | null>(null);

    useEffect(() => {
        fetch('/me', {
            credentials: 'include',
        })
            .then((res) => {
                if (!res.ok) throw new Error('Not authenticated');
                return res.json();
            })
            .then((data) => setUser(data))
            .catch(() => setUser(null));
    }, []);

    return (
        <header className="flex items-center justify-between px-4 py-2 shadow bg-white border-b">
            <h1 className="text-xl font-bold text-pink-600">Project Petunia</h1>
            <div className="flex items-center gap-4">
                {user ? (
                    <>
                        <span className="text-gray-700">👋 Hallo, {user.name}</span>
                        <LogoutButton />
                    </>
                ) : (
                    <Link
                        href="/oauth2/authorization/keycloak"
                        className="flex items-center gap-1 text-sm text-blue-600 hover:underline"
                    >
                        <LogIn size={18} />
                        Login
                    </Link>
                )}
            </div>
        </header>
    );
}
