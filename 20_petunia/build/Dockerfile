FROM eclipse-temurin:17-jre

MAINTAINER felix@zalando.de

COPY nakadi/app/build/libs/app.jar nakadi.jar 

ENTRYPOINT exec java $JAVA_OPTS \
    -Djava.security.egd=file:/dev/./urandom \
    -Dspring.jdbc.getParameterType.ignore=true \
    -jar nakadi.jar
