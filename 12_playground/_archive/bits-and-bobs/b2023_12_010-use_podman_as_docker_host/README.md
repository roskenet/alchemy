# User podman as DOCKER_HOST

```
podman system service --time=0
export DOCKER_HOST=unix:///var/run/user/$(id -u)/podman/podman.sock
```
