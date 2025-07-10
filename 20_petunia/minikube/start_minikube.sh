# Install minikube itself:

## We get the minikube runtime:

```
curl -LO https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64
sudo install minikube-linux-amd64 /usr/local/bin/minikube
sudo ln -s minikube /usr/local/bin/kubectl
```

## Start a cluster:

```shell
minikube start --driver=docker --cpus=2 --memory=4096 --addons=ingress --mount --mount-string="$HOME/Workspaces/minikube/mounts:/mnt"
```

