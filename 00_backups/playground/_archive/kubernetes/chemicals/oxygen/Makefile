build:
	./mvnw clean package docker:build
push:
	./mvnw docker:push
deploy:
	kubectl apply -f deploy/deployment.yaml
	kubectl apply -f deploy/service.yaml
	kubectl apply -f deploy/ingress.yaml
