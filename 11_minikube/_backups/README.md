# Minikube setup

Very cool to have nakadi running locally with all dependent services.

## Prerequesites

Check if we have docker installed:

```
docker ps
```

## Install minikube itself:

0. We get the minikube runtime:

```
curl -LO https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64
sudo install minikube-linux-amd64 /usr/local/bin/minikube
sudo ln -s minikube /usr/local/bin/kubectl
```

This contains everything that might be useful to deploy tools and services on a local developer's device.

```shell
minikube start --driver=docker --cpus=4 --memory=4096 --disk-size=32g --addons=ingress --mount --mount-string="$HOME/Workspaces/minikube/mounts:/mnt"
```

Chose options according your workload and your machine:
(Some might find --dns-domain=minikube useful when using other drivers check for the --disk-size=32g parameter.)

```bash
minikube start --memory=8192 --cpus=4 --driver=docker --mount --mount-string="$HOME/Workspaces/minikube:/mnt"
```

We want to talk to our services by name:

```bash
minikube addons enable ingress
```

or try the kvm driver (I have always problems with user permissions when mounting the filesysytem from the host. I prefer the docker driver as above.)

```
minikube -p mars start --memory=8192 --cpus=4 --dns-domain=mars --driver=kvm2
```
Using a different cluster:
minikube -p mars kubectl -- get pods

Add the ingress addon:
minikube addons enable ingress

Set up databases:
```sql
CREATE USER nakadi CREATEROLE PASSWORD 'nakadi';
CREATE DATABASE nakadi OWNER nakadi;

CREATE USER keycloak PASSWORD 'keycloak';
CREATE DATABASE keycloak OWNER keycloak;
```

