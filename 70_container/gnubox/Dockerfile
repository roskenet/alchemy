FROM ubuntu:25.04

ENV DEBIAN_FRONTEND=noninteractive

RUN apt-get update

# Install base packages
RUN apt-get install -y \
    sudo \
    tightvncserver \
    dbus-x11 x11-xserver-utils \
    vim-gtk3 \
    zsh wget curl git unzip

# Install my OS
RUN apt-get install -y \
    gnustep gnustep-devel \
    wmaker \
    fonts-powerline \
    terminator

# Clean up
RUN apt-get clean

# Install Starship prompt
RUN curl -sS https://starship.rs/install.sh | sh -s -- -y

SHELL ["/usr/bin/zsh", "-c"]

# Create user
ARG HOST_UID=1001
ARG HOST_GID=1001

RUN groupadd -g $HOST_GID developer \
    && useradd -ms /usr/bin/zsh -u $HOST_UID -g $HOST_GID developer \
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
    echo 'exec wmaker &' >> "/home/developer/.vnc/xstartup"
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
