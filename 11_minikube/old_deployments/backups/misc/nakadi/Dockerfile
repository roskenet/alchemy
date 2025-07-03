FROM eclipse-temurin:11-alpine

MAINTAINER Team Aruha, team-aruha@zalando.de

WORKDIR /
ADD app/build/libs/app.jar nakadi.jar
COPY app/api/nakadi-event-bus-api.yaml api/nakadi-event-bus-api.yaml

ENTRYPOINT exec java -Djava.security.egd=file:/dev/./urandom -Dspring.jdbc.getParameterType.ignore=true -jar nakadi.jar
