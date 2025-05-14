all: build push deploy
build:
	docker build -t roskenet/postgres:14.0.0 .
push:
	docker push roskenet/postgres:14.0.0 
deploy:
	kubectl apply -f postgres-storage.yaml
	kubectl apply -f postgres-configmap.yaml
	kubectl apply -f postgres-deployment.yaml
	kubectl apply -f postgres-service.yaml

