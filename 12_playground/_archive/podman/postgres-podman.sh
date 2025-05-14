podman pull docker.io/postgres:15 && \
podman run -d -v /home/froske/var/run/postgresql:/var/run/postgresql -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres --name postgres-15 -p 5432:5432 docker.io/postgres:15
