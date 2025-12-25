FROM eclipse-temurin:17-jre

ADD kafka_2.13-3.4.0.tgz /opt

RUN /opt/kafka_2.13-3.4.0/bin/kafka-storage.sh format -t vpPWYZ9ZTAeSoDmvOQCRMQ -c /opt/kafka_2.13-3.4.0/config/kraft/server.properties

ADD startup.sh /opt/startup.sh
RUN chmod +x /opt/startup.sh

CMD ["/opt/startup.sh"]

