#############################
# 1. STAGE: Build Container
#############################

FROM ubuntu:24.04 AS builder

ENV DEBIAN_FRONTEND=noninteractive
WORKDIR /opt

RUN apt-get update && apt-get install -y \
    wget unzip curl gnupg \
    postgresql \
    zookeeperd \
    openjdk-17-jdk \
    supervisor \
    netcat-traditional \
    net-tools \
    iputils-ping \
    && apt-get clean && rm -rf /var/lib/apt/lists/*

# Kafka installieren
ENV KAFKA_VERSION=3.9.0
ENV SCALA_VERSION=2.13
RUN wget https://downloads.apache.org/kafka/${KAFKA_VERSION}/kafka_${SCALA_VERSION}-${KAFKA_VERSION}.tgz && \
    tar -xzf kafka_${SCALA_VERSION}-${KAFKA_VERSION}.tgz && \
    mv kafka_${SCALA_VERSION}-${KAFKA_VERSION} /opt/kafka && \
    rm kafka_${SCALA_VERSION}-${KAFKA_VERSION}.tgz

# JAR und config + Skripte kopieren
COPY nakadi/app/build/libs/app.jar /opt/nakadi.jar
COPY application.yml /opt/application.yml
COPY nakadi/database/nakadi /tmp/database
COPY scripts/start.sh /opt/start.sh
COPY scripts/init-db.sh /opt/init-db.sh
COPY scripts/supervisord.conf /etc/supervisor/conf.d/supervisord.conf
RUN chmod +x /opt/start.sh /opt/init-db.sh


#############################
# 2. STAGE: Runtime Container
#############################

FROM ubuntu:24.04

ENV DEBIAN_FRONTEND=noninteractive
WORKDIR /opt

# Nur Runtime-Abhängigkeiten
RUN apt-get update && apt-get install -y \
    openjdk-17-jre \
    postgresql \
    zookeeperd \
    supervisor \
    netcat-traditional \
    net-tools \
    iputils-ping \
    curl \
    && apt-get clean && rm -rf /var/lib/apt/lists/*

# NUR das Nötigste aus dem Build-Container übernehmen
COPY --from=builder /opt/nakadi.jar /opt/nakadi.jar
COPY --from=builder /opt/application.yml /opt/application.yml
COPY --from=builder /opt/kafka /opt/kafka
COPY --from=builder /tmp/database /tmp/database
COPY --from=builder /opt/start.sh /opt/start.sh
COPY --from=builder /opt/init-db.sh /opt/init-db.sh
COPY --from=builder /etc/supervisor/conf.d/supervisord.conf /etc/supervisor/conf.d/supervisord.conf

RUN chmod +x /opt/start.sh /opt/init-db.sh
RUN mkdir -p /var/log/supervisor

CMD ["/opt/start.sh"]

