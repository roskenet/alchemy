#!/usr/bin/env zsh
source ~/.zshrc

sdk use java 8.0.412-zulu
mvn verify

sdk use java 21.0.3-zulu
mvn sonar:sonar \
  -Dsonar.projectKey=clarifications-api \
  -Dsonar.projectName='clarifications-api' \
  -Dsonar.host.url=http://sonar.192-168-49-2.nip.io \
  -Dsonar.token=sqp_083bc3593b9dcc5f2ce90ab0d1e00361edd3a10f
