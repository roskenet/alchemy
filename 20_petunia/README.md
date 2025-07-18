# Project Petunia

A fictional microservice garden OpenID Connect secured with keycloak.
This project uses typical elements and patterns that you find in an enterprise application.

Frontends, Backends, Microservices, REST APIs, OpenID Connect, Event Driven Architecture, Kubernetes deployments.


felix@roskenet.de

https://www.felix-roske.de/

# Passwords 

Encrypt the passwords with production@petunia:

```bash
echo "your-secure-password" | gpg --encrypt --armor --recipient production@petunia 
```

For a one-liner that doesn't leave the password in shell history:

```bash
gpg --encrypt --armor --recipient production@petunia <<< "your-secure-password"
```

## Petunia alpicola

The frontend a next.js based application.

## Petunia villadiana

A Spring Boot BFF that does session management for the alpicola frontend.

## Petunia axillaris

A Spring Boot REST service client_credentials flow secured.


## Petnua species

    Petunia alpicola
    Petunia axillaris
    Petunia bajeensis
    Petunia bonjardinensis
    Petunia exserta
    Petunia guarapuavensis
    Petunia inflata
    Petunia integrifolia
    Petunia interior
    Petunia ledifolia
    Petunia littoralis
    Petunia mantiqueirensis
    Petunia occidentalis
    Petunia patagonica
    Petunia reitzii
    Petunia riograndensis
    Petunia saxicola
    Petunia scheideana
    Petunia villadiana
    Petunia × atkinsiana
