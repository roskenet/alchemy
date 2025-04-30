# Use sonar for our projects

~/.local/bin/sonar-scanner/bin/sonar-scanner \
  -Dsonar.projectKey=outbound-api \
  -Dsonar.sources=. \
  -Dsonar.host.url=http://sonar.minikube \
  -Dsonar.token=sqp_a76215fd0414c48076906bace4288810e3e171c5

sdk use java 11.0.22-zulu
./mvnw clean verify

sdk use java 21.0.3-zulu
./mvnw sonar:sonar \
  -Dsonar.projectKey=outbound-api \
  -Dsonar.projectName='outbound-api' \
  -Dsonar.host.url=http://sonar.minikube \
  -Dsonar.token=sqp_a76215fd0414c48076906bace4288810e3e171c5
