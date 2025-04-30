#!/usr/bin/env zsh
source ~/.zshrc

sdk use java 11.0.22-zulu
./mvnw verify

sdk use java 21.0.3-zulu
./mvnw sonar:sonar \
  -Dsonar.projectKey=backstage-content-service \
  -Dsonar.projectName='backstage-content-service' \
  -Dsonar.host.url=http://sonar.192-168-49-2.nip.io \
  -Dsonar.token=sqp_439523654cdded41a54cb4f90c28c080a515a305

# 
#  -Dsonar.host.url=http://sonar.192-168-49-2.nip.io \
#  Sometimes we get an 413 then forward port 9000 to -> 9090 locally
