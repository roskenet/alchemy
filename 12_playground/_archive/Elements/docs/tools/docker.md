# Docker

## Start a container

```bash
docker run -ti --name ubuntu ubuntu:19.10 /bin/bash
```

```bash
docker start ubuntu
docker attach ubuntu
```

```bash
docker start ubuntu
docker exec -ti ubuntu /bin/bash
```
