# CREATE USER nakadi WITH PASSWORD 'nakadi' CREATEROLE;
# CREATE DATABASE nakadi owner nakadi;

find . -type f -name "*.sql" | sort |
while read -r filename; do psql -h localhost -U nakadi -d nakadi -a -f "$filename"; done
