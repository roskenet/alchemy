# Mars k8s cluster

```sh
minikube start --profile=mars --driver=kvm2 --mount --mount-string="$HOME/Workspaces/mars:/data" --disk-size=32g --dns-domain=mars --cpus=2
```

```sh
alias mars='minikube --profile mars kubectl --'

```
