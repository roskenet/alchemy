import type { NextConfig } from "next";

// const nextConfig: NextConfig = {
//   reactStrictMode: true,
// };

// export default nextConfig;

const nextConfig: NextConfig = {
  output: 'export',
  trailingSlash: true, // wichtig für nginx oder andere static hosts
  images: {
    unoptimized: true, // falls du das Next.js image optimization nicht brauchst
  },
};

export default nextConfig;