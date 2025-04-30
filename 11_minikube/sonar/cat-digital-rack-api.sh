#!/usr/bin/env zsh
source ~/.zshrc

sdk use java 17.0.10-zulu
mvn verify

sdk use java 21.0.3-zulu
mvn sonar:sonar \
  -Dsonar.projectKey=cat-digital-rack-api \
  -Dsonar.projectName='cat-digital-rack-api' \
  -Dsonar.host.url=http://sonar.192-168-49-2.nip.io \
  -Dsonar.token=sqp_060c464f64ca54e7c196892f3c61b6241a16c3c6
