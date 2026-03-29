./mvnw clean verify sonar:sonar \
  -Dsonar.projectKey=hydrogen \
  -Dsonar.projectName='hydrogen' \
  -Dsonar.host.url=http://sonar.minikube \
  -Dsonar.token=sqp_0cec1a6f6fc0468c109c3b73b687c6ae10cf8ac7
