# === STAGE 1 Dependencies installieren ===
FROM node:20-alpine AS deps
WORKDIR /app
COPY package.json package-lock.json ./
RUN npm ci --only=production && npm cache clean --force

# === STAGE 2: App bauen ===
FROM node:20-alpine AS builder
WORKDIR /app
# COPY --from=deps /app/node_modules ./node_modules
COPY package.json package-lock.json ./
RUN npm ci
COPY . .
RUN npm run build

# --- STAGE 3: Install only production deps ---
FROM node:20-alpine AS prod-deps
WORKDIR /app
COPY package.json package-lock.json ./
RUN npm ci --omit=dev

# === STAGE 4: Minimal runtime ===
FROM node:20-alpine AS runner
WORKDIR /app

ENV NODE_ENV=production

# Nur das Nötigste übernehmen
COPY --from=builder /app/public ./public
COPY --from=builder /app/.next ./.next
COPY --from=builder /app/node_modules ./node_modules
COPY --from=builder /app/package.json ./

EXPOSE 3000

CMD ["npx", "next", "start"]
