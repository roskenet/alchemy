# A developers minikube

mkdir -p $HOME/.local/var/minikube

minikube start --driver=docker --mount --mount-string="$HOME/.local/var/minikube:/mnt/minikube"
minikube addons enable ingress

Check your ip:

minikube ip

## A persistent PostgreSQL
Install a postgresql server:

mkdir -p $HOME/.local/var/minikube/mounts/postgres/data

and apply configmap deployment service

Apply these patches:

kubectl patch configmap tcp-services -n ingress-nginx --patch '{"data":{"5432":"default/postgres:5432"}}'

kubectl patch deployment ingress-nginx-controller --patch "$(cat ingress-nginx-controller-patch.yaml)" -n ingress-nginx


## Nakadi and nakadi ui

CREATE USER nakadi WITH PASSWORD 'nakadi' CREATEROLE;
CREATE DATABASE nakadi OWNER nakadi;

and apply the database scripts
