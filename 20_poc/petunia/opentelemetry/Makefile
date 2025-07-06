APP_NAME=otel-collector
APP_VERSION=1.0.0
IMAGE_NAME=roskenet/$(APP_NAME):${APP_VERSION}
CONTAINER_NAME=$(APP_NAME)
PORT=4317

.PHONY: deploy undeploy 

deploy: 
		kubectl config use-context minikube
		kubectl apply -f otel-collector.yaml
undeploy:
		kubectl config use-context minikube
		kubectl delete -f otel-collector.yaml
