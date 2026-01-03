# Run a postgresql on podman

With persistent data dir:

podman pull docker.io/postgres:15 && \
podman run -d \
-v /home/froske/container/postgresql/run:/var/run/postgresql \
-v /home/froske/container/postgresql/data:/var/lib/postgresql/data \
-e PGDATA=/var/lib/postgresql/data/pgdata \
-e POSTGRES_USER=postgres \
-e POSTGRES_PASSWORD=postgres \
--name postgres-15 \
-p 5432:5432 \
docker.io/postgres:15
