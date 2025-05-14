IMAGE_NAME := nakadi-test
TAG := latest
CONTAINER_NAME := $(IMAGE_NAME)-container

.PHONY: build run stop remove logs shell

## Default: baue das Image
build:
	docker build -t $(IMAGE_NAME):$(TAG) .

## Baue mit frischem Cache (z. B. nach Änderungen in apt oder base image)
rebuild:
	docker build --no-cache -t $(IMAGE_NAME):$(TAG) .

## Container starten (falls noch nicht läuft)
run:
	docker run -d --name $(CONTAINER_NAME) -p 8080:8080 -p 5432:5432 -p 9092:9092 -p 2181:2181 $(IMAGE_NAME):$(TAG)

## Container stoppen
stop:
	docker stop $(CONTAINER_NAME) || true

## Container entfernen
remove:
	docker rm $(CONTAINER_NAME) || true

## Logs anschauen
logs:
	docker logs -f $(CONTAINER_NAME)

## In den Container reinspringen
shell:
	docker exec -it $(CONTAINER_NAME) bash

## Build + Run in einem Rutsch
restart: stop remove build run logs

