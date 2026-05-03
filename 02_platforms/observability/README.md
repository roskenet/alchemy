# Grafana Crash Course

## Grafana starten

```
podman network create observability
```

```
podman run -d \
  --name grafana \
  -p 3000:3000 \
  docker.io/grafana/grafana
```

```
podman run -d \
  --name postgres \
  --network observability \
  -e POSTGRES_PASSWORD=secret \
  -e POSTGRES_DB=metrics \
  -p 5432:5432 \
  docker.io/library/postgres
```

```
global:
  scrape_interval: 5s

scrape_configs:
  - job_name: 'prometheus'
    static_configs:
      - targets: ['localhost:9090']
```

```
podman run -d \
  --name prometheus \
  --network observability \
  -p 9090:9090 \
  -v $(pwd)/prometheus.yml:/etc/prometheus/prometheus.yml:Z \
  docker.io/prom/prometheus
```

```
podman run -d \
  --name jaeger \
  --network observability \
  -p 16686:16686 \
  -p 4317:4317 \
  docker.io/jaegertracing/all-in-one
```

## Connecting to postgres

podman exec -it postgres psql -U postgres -d metrics

INSERT INTO cpu_usage VALUES
(NOW() - INTERVAL '5 minutes', 'server-1', 0.5),
(NOW() - INTERVAL '4 minutes', 'server-1', 0.6),
(NOW() - INTERVAL '3 minutes', 'server-1', 0.7),
(NOW() - INTERVAL '2 minutes', 'server-1', 0.65),
(NOW() - INTERVAL '1 minutes', 'server-1', 0.8);

