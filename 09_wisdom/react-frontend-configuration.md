# Frontend Environment Configuration Patterns with a BFF

When working with a frontend application backed by a BFF (Backend for Frontend), managing environment variables across different deployment stages (Development, Staging, Production) requires avoiding build-time baking (`NEXT_PUBLIC_` or `VITE_` variables) if you want true "build once, deploy anywhere" capability.

When a BFF is present, you can adopt robust runtime configuration patterns. Below are the three most common and effective patterns.

## Pattern 1: Runtime Injection via HTML Script Tag (SSR / Containerized BFF)

If your BFF (e.g., Node.js, Express, Fastify, or Next.js Server) serves the initial HTML document, the BFF can read its own environment variables (`process.env.*`) at runtime and inject them directly into the HTML response as a global JavaScript object (`window.__ENV__`).

### How It Works
1. The BFF reads environment variables when rendering the HTML shell.
2. It injects a tiny script tag into the `<head>`:
   ```html
   <script>
     window.__ENV__ = {
       API_BASE_URL: "https://api.staging.example.com",
       FEATURE_FLAG_X: "true"
     };
   </script>
   ```
3. The frontend application reads `window.__ENV__` at runtime rather than relying on bundled build-time variables.

### Implementation Helper in React / Next.js
```typescript
// src/config/env.ts
interface RuntimeEnv {
  API_BASE_URL: string;
  FEATURE_FLAG_X: string;
}

declare global {
  interface Window {
    __ENV__?: RuntimeEnv;
  }
}

export const getEnv = (): RuntimeEnv => {
  if (typeof window === 'undefined') {
    // Server-side (BFF / SSR)
    return {
      API_BASE_URL: process.env.API_BASE_URL || 'http://localhost:4000',
      FEATURE_FLAG_X: process.env.FEATURE_FLAG_X || 'false',
    };
  }

  // Client-side runtime injection from BFF
  return {
    API_BASE_URL: window.__ENV__?.API_BASE_URL || 'http://localhost:4000',
    FEATURE_FLAG_X: window.__ENV__?.FEATURE_FLAG_X || 'false',
  };
};
```

### Pros & Cons
- **Pros**: Zero async network latency on startup; works instantly on first render; single immutable build artifact can be promoted across environments.
- **Cons**: Requires server-rendered HTML (SSR or backend template rendering).

---

## Pattern 2: Runtime Configuration Endpoint (`/api/config`)

If your frontend is a purely static SPA hosted on a CDN (like AWS S3, CloudFront, or Nginx) while your BFF runs on a separate server or serverless function, the frontend cannot receive injected HTML attributes. Instead, it fetches configuration from the BFF upon startup.

### How It Works
1. The BFF exposes a lightweight public endpoint, e.g., `GET /api/config`.
2. The BFF responds with a JSON payload of allowed public environment variables:
   ```json
   {
     "apiUrl": "https://api.production.example.com",
     "environment": "production"
   }
   ```
3. The frontend application fetches this config during its initialization phase (e.g., in `main.tsx` or inside a React Context / Provider before rendering the main UI).

### Example Implementation
```typescript
// src/services/config.ts
let configCache: Record<string, string> = {};

export async function loadConfig(): Promise<void> {
  try {
    const response = await fetch('/api/config');
    configCache = await response.json();
  } catch (error) {
    console.error('Failed to load runtime configuration, using fallbacks', error);
  }
}

export function getConfig(key: string, fallback: string = ''): string {
  return configCache[key] || fallback;
}
```

### Pros & Cons
- **Pros**: Completely decouples static hosting from runtime configuration; works with any static hosting provider.
- **Cons**: Adds a network round-trip before the app can fully initialize, requiring a loading state or skeleton screen.

---

## Pattern 3: Next.js App Router Server-to-Client Passing (Native BFF)

If your Next.js application acts as its own BFF (handling server-side rendering, API routes, and Server Actions), Next.js natively bridges the environment variable gap via **React Server Components (RSCs)**.

### How It Works
In Next.js App Router, code inside Server Components runs exclusively on the server (the BFF). Server Components can access standard environment variables (`process.env.MY_VAR`) without any `NEXT_PUBLIC_` prefix, and safely pass them down to Client Components as props.

### Example Implementation
```tsx
// src/app/page.tsx (Server Component)
import { ClientDashboard } from '@/components/ClientDashboard';

export default function Page() {
  const apiEndpoint = process.env.BFF_API_ENDPOINT || 'http://localhost:3000/api';
  const environmentName = process.env.NODE_ENV;

  return (
    <main>
      <ClientDashboard 
        apiEndpoint={apiEndpoint} 
        environment={environmentName} 
      />
    </main>
  );
}
```

```tsx
// src/components/ClientDashboard.tsx ('use client')
'use client';

interface Props {
  apiEndpoint: string;
  environment: string;
}

export function ClientDashboard({ apiEndpoint, environment }: Props) {
  return (
    <div>
      <p>Connected to API: {apiEndpoint}</p>
      <p>Environment: {environment}</p>
    </div>
  );
}
```

### Pros & Cons
- **Pros**: Highly idiomatic in Next.js; keeps sensitive server secrets out of client bundles while seamlessly passing configuration to client components; no extra endpoints needed.
- **Cons**: Tied specifically to Next.js Server Components architecture.

---

## Summary Recommendation

- If using **Next.js as your BFF**: Use **Pattern 3** (pass environment variables from Server Components to Client Components).
- If using a **Containerized SPA / SSR BFF (Node/Express)**: Use **Pattern 1** (`window.__ENV__` injection in the HTML shell) for optimal performance and zero startup latency.
- If using **Decoupled Static Hosting + API BFF**: Use **Pattern 2** (`GET /api/config`).
