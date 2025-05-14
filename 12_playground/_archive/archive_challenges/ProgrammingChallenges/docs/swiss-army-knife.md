# Swiss Army Knife

This is a docker image for k8s.

## Build it

```sh
make build
```

## Push it
```sh
docker login
make push
```

## Run it as local docker container

```sh
docker run -it roskenet/swissknife:1.0.0 /bin/bash
```

## Run it as a k8s pod
```sh
eval $(minikube -p challenges docker-env)
make build
minikube -p challenges kubectl apply -- -f swissknife.yaml
minikube -p challenges kubectl exec -- -it swissknife -- /bin/bash
```
