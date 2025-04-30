# CREATE USER nakadi WITH PASSWORD 'nakadi' CREATEROLE;
# CREATE DATABASE nakadi owner nakadi;

find . -type f -name "*.sql" | sort |
while read -r filename; do psql -h postgres.192-168-49-2.nip.io -U nakadi -d nakadi -a -f "$filename"; done
