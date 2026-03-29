FROM ubuntu:24.10

# Vermeide interaktive Prompts bei apt
ENV DEBIAN_FRONTEND=noninteractive

# Installiere Abhängigkeiten und Docker
RUN apt-get update && apt-get install -y \
    ca-certificates \
    curl \
    gnupg \
    lsb-release \
    apt-transport-https \
    software-properties-common && \
    \
    # Docker GPG Key hinzufügen
    mkdir -p /etc/apt/keyrings && \
    curl -fsSL https://download.docker.com/linux/ubuntu/gpg | gpg --dearmor -o /etc/apt/keyrings/docker.gpg && \
    \
    # Docker Repo hinzufügen
    echo "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.gpg] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable" \
    > /etc/apt/sources.list.d/docker.list && \
    \
    # Docker installieren
    apt-get update && apt-get install -y \
    docker-ce \
    docker-ce-cli \
    containerd.io \
    docker-buildx-plugin \
    docker-compose-plugin && \
    \
    # Aufräumen
    apt-get clean && rm -rf /var/lib/apt/lists/*

# docker-compose als alias für CLI-Plugin verfügbar machen
RUN ln -s /usr/libexec/docker/cli-plugins/docker-compose /usr/local/bin/docker-compose

CMD ["bash"]
 


