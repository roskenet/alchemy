FROM ubuntu:25.04

ENV DEBIAN_FRONTEND=noninteractive

# Install base packages
RUN apt-get update && apt-get install -y \
    sudo \
    xfce4 xfce4-goodies \
    tightvncserver \
    dbus-x11 x11-xserver-utils \
    wget curl git \
    && apt-get clean


# Create user
ARG HOST_UID=1001
ARG HOST_GID=1001

RUN groupadd -g $HOST_GID developer \
    && useradd -m -u $HOST_UID -g $HOST_GID developer \
    && echo "developer:password" | chpasswd \
    && adduser developer sudo

RUN cat << 'EOF' > /start.sh
#!/bin/bash

# Init only if not already present
if [ ! -f "/home/developer/.vnc/passwd" ]; then
    echo "Setting up VNC for the first time..."
    mkdir -p "/home/developer/.vnc"
    echo "password" | vncpasswd -f > "/home/developer/.vnc/passwd"
    chmod 600 "/home/developer/.vnc/passwd"

    echo '#!/bin/bash' > "/home/developer/.vnc/xstartup"
    echo 'startxfce4 &' >> "/home/developer/.vnc/xstartup"
    chmod +x "/home/developer/.vnc/xstartup"
fi

# Start VNC
vncserver :1 -geometry 1920x1200 -depth 24

# Keep container running
tail -F $HOME/.vnc/*.log
EOF

RUN chmod +x /start.sh

USER developer
ENV USER=developer 
WORKDIR /home/developer

# Expose VNC port
EXPOSE 5901

# Start VNC server
CMD ["/start.sh"]
