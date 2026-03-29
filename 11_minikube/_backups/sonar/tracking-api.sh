sdk use java 8.0.412-zulu
./mvnw verify

sdk use java 21.0.3-zulu
./mvnw sonar:sonar \
  -Dsonar.projectKey=tracking-api \
  -Dsonar.projectName='tracking-api' \
  -Dsonar.host.url=http://sonar.minikube \
  -Dsonar.token=sqp_4598b78092eb9f0a96ebbc6cbed47ab51f81a642


