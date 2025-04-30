PGPASSWORD=postgres psql -h postgres.minikube -U postgres -d postgres -c "CREATE USER nakadi PASSWORD 'nakadi' CREATEROLE"
PGPASSWORD=postgres psql -h postgres.minikube -U postgres -d postgres -c "CREATE DATABASE nakadi OWNER nakadi"

# cd into the nakadi database dir:

find ./build/nakadi/database/nakadi/10_data -type f -name "*.sql" | sort |
while read -r filename; do PGPASSWORD=nakadi psql -h postgres.minikube -U "nakadi" -d "nakadi" -a -f "$filename"; done
