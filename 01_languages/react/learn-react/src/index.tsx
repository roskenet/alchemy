import React, { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';

const root = createRoot(
    document.getElementById('root') as HTMLElement
);

function App() {
  return (
      <>
        <h1>My React App!</h1>
        <p>This is a test!</p>
      </>
  )
}

root.render(
    <StrictMode>
      <App />
    </StrictMode>
);