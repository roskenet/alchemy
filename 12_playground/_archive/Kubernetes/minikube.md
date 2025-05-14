minikube config set rootless true
minikube start --driver=podman --container-runtime=containerd

https://minikube.sigs.k8s.io/docs/drivers/podman/

minikube start --alsologtostderr -v=7
