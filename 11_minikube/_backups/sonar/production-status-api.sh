#!/usr/bin/env zsh
source ~/.zshrc

sdk use java 11.0.22-zulu
./mvnw verify

sdk use java 21.0.2-zulu

./mvnw sonar:sonar \
  -Dsonar.projectKey=production-status-api \
  -Dsonar.projectName='production-status-api' \
  -Dsonar.host.url=http://sonar.192-168-49-2.nip.io \
  -Dsonar.token=sqp_0e8ca3f907a368917873efad0bb6fbb452d18172
