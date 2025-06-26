# Project Petunia

A fictional microservice garden OpenID Connect secured with keycloak.
This project uses typical elements and patterns that you find in an enterprise application.

Frontends, Backends, Microservices, REST APIs, OpenID Connect, Event Driven Architecture, Kubernetes deployments.


felix@roskenet.de

https://www.felix-roske.de/

# Passwords 

The deployments for minikube use the following password rules:

Things like keycloak and postgres that have special "admin" accounts should have <servicename> / password. For example postgres/password and keycloak/password.

## Petunia alpicola

The frontend a next.js based application.

## Petunia villadiana

A backend and front controller that does session management for the alpicola frontend.

