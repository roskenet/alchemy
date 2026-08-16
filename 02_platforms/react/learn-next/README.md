# learn-next

A Next.js application configured with standard defaults, TypeScript, ESLint, PostCSS, and Mantine UI components.

## Features & Setup

- **Next.js (App Router)**: Utilizing React Server Components and file-based routing in `src/app/`
- **TypeScript**: Configured with path aliases (`@/*` mapping to `./src/*`)
- **Mantine UI (`@mantine/core`, `@mantine/hooks`)**: Fully integrated with `@mantine/core/styles.css`, `MantineProvider`, and `ColorSchemeScript`
- **Tabler Icons (`@tabler/icons-react`)**: Pre-configured icon library for UI elements
- **PostCSS**: Configured with `postcss-preset-mantine` and `postcss-simple-vars`

## Getting Started

First, run the development server:

```bash
npm run dev
```

Open [http://localhost:3000](http://localhost:3000) with your browser to see the result.

## Available Scripts

- `npm run dev`: Starts the local development server
- `npm run build`: Creates an optimized production build
- `npm run start`: Starts the Next.js production server
- `npm run lint`: Runs Next.js ESLint checks

## Project Structure

```text
learn-next/
├── src/
│   ├── app/
│   │   ├── layout.tsx     # Root layout with MantineProvider and ColorSchemeScript
│   │   └── page.tsx       # Landing page showcasing Mantine components
│   ├── components/
│   │   └── ColorSchemeToggle.tsx  # Light/Dark/Auto color scheme switcher
│   └── theme.ts           # Custom Mantine theme override definition
├── postcss.config.mjs     # PostCSS configuration with Mantine preset & vars
├── tsconfig.json          # TypeScript configuration
├── package.json           # Dependencies and project scripts
└── .eslintrc.json         # ESLint configuration
```
