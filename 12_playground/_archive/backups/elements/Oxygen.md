# Oxygen

Builds and installs a K8s webservice. 

## hello-service

Use the docker engine of minikube:

```bash
eval $(minikube docker-env)
```

Build the *hello-service*:

```bash
docker build -t hello-service:0.0.1 .
```

Deploy it in minikube:

```bash
kubectl create -f deploy/namespace.yaml
kubectl create -f deploy/deployment.yaml
kubectl create -f deploy/service.yaml
kubectl create -f deploy/ingress.yaml
```

```bash
sudo echo $(minikube ip) " oxygen.minikube" >> /etc/hosts
```
