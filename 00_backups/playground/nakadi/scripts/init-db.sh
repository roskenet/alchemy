#!/bin/bash

DB_DIR="/var/lib/postgresql/16/main"

rm -rf $DB_DIR

# Datenverzeichnis initialisieren, wenn nicht vorhanden
if [ ! -f "$DB_DIR/PG_VERSION" ]; then
  echo "Initialisiere PostgreSQL-Datenverzeichnis ..."
  mkdir -p "$DB_DIR"
  chown -R postgres:postgres "$DB_DIR"
  su - postgres -c "/usr/lib/postgresql/16/bin/initdb -D $DB_DIR"
fi

# PostgreSQL temporär starten für DB-Init
echo "Starte temporär PostgreSQL zum Erstellen der Nakadi-DB ..."
su - postgres -c "/usr/lib/postgresql/16/bin/pg_ctl -D $DB_DIR -w start"

# DB und User anlegen, falls nicht vorhanden
echo "Erstelle Datenbank 'nakadi' und User 'nakadi' ..."
su - postgres -c "psql -tc \"SELECT 1 FROM pg_database WHERE datname = 'nakadi'\" | grep -q 1 || psql <<EOF
CREATE USER nakadi WITH PASSWORD 'nakadi' CREATEROLE;
CREATE DATABASE nakadi OWNER nakadi;
GRANT ALL PRIVILEGES ON DATABASE nakadi TO nakadi;
EOF"

find /tmp/database -type f -name "*.sql" | sort |
while read -r filename; do psql -U nakadi -d nakadi -a -f $filename; done


# PostgreSQL wieder beenden
echo "Stoppe temporären PostgreSQL-Server ..."
su - postgres -c "/usr/lib/postgresql/16/bin/pg_ctl -D $DB_DIR -m fast stop"
