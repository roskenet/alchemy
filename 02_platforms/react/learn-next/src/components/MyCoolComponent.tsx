'use client';

interface MyCoolComponentProps {
    name?: string
}

export function MyCoolComponent({name}: MyCoolComponentProps) {
    return (
        <div>
            <p>Hello {name || 'Unbekannt'}!</p>
        </div>
    );
}

