# Chemicals Playground Cluster

```shell
minikube start --profile=chemicals --driver=docker --addons=ingress,metrics-server --mount --mount-string="$HOME/.local/var/chemicals:/mnt"  
```

