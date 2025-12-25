build:
	eval $(minikube -p minikube docker-env)
	docker build -t roskenet/servicepod:1.0.0 .

push:
	eval $(minikube -p minikube docker-env)
	docker push roskenet/servicepod:1.0.0

deploy:
	kubectl apply -f servicepod.yaml
