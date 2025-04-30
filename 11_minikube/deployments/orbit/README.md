# Minikube

## Create images
eval $(minikube -p minikube docker-env)
./mvnw package docker:build

## Get images from pierone
### Get base images
docker pull container-registry.zalando.net/library/eclipse-temurin-8-jre:latest

### Get our app images
docker pull pierone.stups.zalan.do/cpp/outbound-api:master-110

### Tag images
docker tag pierone.stups.zalan.do/cpp/tracking-api:latest tracking-api:latest

## Configure
Configure your runtime variables in config.yaml

## Deply
kubectl config use-context minikube

kubectl apply -f config.yaml
kubectl apply -f deployment.yaml
kubectl apply -f service.yaml
kubectl apply -f ingress.yaml

## Restart
kubectl rollout restart deployment outbound-api

