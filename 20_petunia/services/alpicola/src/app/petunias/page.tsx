'use client';

import { useAuthenticatedFetch } from '@/lib/hooks/useAuthenticatedFetch';
import LogoutButton from "@/components/LogoutButton";
import {useEffect, useState} from "react";
import {Client} from "@stomp/stompjs";
import SockJS from 'sockjs-client';

type Petunia = {
    name: string;
    image_url: string;
};

export default function PetuniasPage() {
    const [message, setMessage] = useState("Noch nichts empfangen...");
    const { data: petunias, error, loading } =
        useAuthenticatedFetch<Petunia[]>('/api/petunias');

    useEffect(() => {
        const socket = new SockJS('http://localhost:8080/ws');
        const client = new Client({
            webSocketFactory: () => socket as WebSocket,
            onConnect: () => {
                client.subscribe('/topic/petunias', (msg) => {
                    setMessage(msg.body);
                });
            },
            debug: (str) => console.log(str),
        });

        client.activate();

        return () => {
            client.deactivate();
        };
    }, []);

    if (loading) {
        return <p>Lade Petunien …</p>;
    }

    if (error) {
        return <p style={{ color: 'red' }}>Fehler: {error}</p>;
    }

    if (!petunias || petunias.length === 0) {
        return <p>Keine Petunien gefunden.</p>;
    }


    return (
        <div>
            <LogoutButton />
            <h1>Petunien</h1>
            <ul>
                {petunias.map((p, i) => (
                    <li key={i}>{p.name}</li>
                ))}
            </ul>
            <div className="p-4">
                <h1 className="text-xl font-bold">🎯 Live-Nachricht:</h1>
                <p className="text-lg mt-2">{message}</p>
            </div>
        </div>
    );
}
