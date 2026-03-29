mvn clean verify sonar:sonar \
  -Dsonar.projectKey=inbound-api \
  -Dsonar.projectName='inbound-api' \
  -Dsonar.host.url=http://sonar.192-168-49-2.nip.io \
  -Dsonar.token=sqp_9fec66a84175ee45d5e866fcfaa32f56af33e5c6
