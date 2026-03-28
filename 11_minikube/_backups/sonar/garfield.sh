#!/usr/bin/env zsh
source ~/.zshrc

sdk use java 8.0.392-tem
./mvnw verify

sdk use java 21.0.2-zulu

mvn sonar:sonar \
  -Dsonar.projectKey=garfield \
  -Dsonar.projectName='garfield' \
  -Dsonar.host.url=http://sonar.192-168-49-2.nip.io \
  -Dsonar.token=sqp_81c2ec659361f0cef928ee2f326cc2345a4a2760
