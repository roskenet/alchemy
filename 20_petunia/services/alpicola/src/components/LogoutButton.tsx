// components/LogoutButton.tsx
'use client';

export default function LogoutButton() {
  const handleLogout = () => {
    window.location.href = `${process.env.NEXT_PUBLIC_API_BASE_URL}/logout`;
  };

  return (
    <button onClick={handleLogout}>
      Logout
    </button>
  );
}