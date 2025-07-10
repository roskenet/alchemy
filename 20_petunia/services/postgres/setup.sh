#!/usr/bin/env bash
kubectl config use-context minikube

kubectl patch configmap tcp-services -n ingress-nginx --patch '{"data":{"5432":"default/postgres:5432"}}'
kubectl patch deployment ingress-nginx-controller --patch "$(cat ingress-nginx-controller-patch.yaml)" -n ingress-nginx

mkdir -p ~/Workspaces/minikube/mounts/postgres/data
kubectl apply -f deployment.yaml
kubectl apply -f service.yaml
