sdk use java 8.0.412-zulu

./mvnw clean verify 

sdk use java 21.0.3-zulu

./mvnw -s $HOME/.m2/settings-zalando.xml sonar:sonar \
  -Dsonar.projectKey=orbit-dashboard-api \
  -Dsonar.projectName='orbit-dashboard-api' \
  -Dsonar.host.url=http://sonar.192-168-49-2.nip.io \
  -Dsonar.token=sqp_a2c67837ebec64f278d4df65f8ffc62ef90ec47e
