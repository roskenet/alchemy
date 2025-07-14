APP_NAME=alpicola
APP_VERSION=2.65.0
IMAGE_NAME=roskenet/$(APP_NAME):${APP_VERSION}
CONTAINER_NAME=$(APP_NAME)
PORT=3000

.PHONY: build run stop dev logs deploy clean

build:
	docker build -t $(IMAGE_NAME) .

run:
	docker run -d --rm \
		--name $(CONTAINER_NAME) \
		-p $(PORT):3000 \
		$(IMAGE_NAME)

stop:
	docker stop $(CONTAINER_NAME)

dev:
	npm run dev

logs:
	docker logs -f $(CONTAINER_NAME)

clean: stop
	docker rmi $(IMAGE_NAME)

deploy: build
		kubectl config use-context minikube
	        cat deploy/deployment.yaml | sed "s/\$$VERSION/$(APP_VERSION)/g" | kubectl apply -f -

undeploy:
		kubectl config use-context minikube
		kubectl delete -f deploy/deployment.yaml
