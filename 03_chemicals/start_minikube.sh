# Start a minikube

minikube start --profile=chemicals --driver=docker --addons=ingress,metrics-server --mount --mount-string="$HOME/Temp/mnt-chemicals:/mnt"

minikube start --driver=docker --addons=ingress,metrics-server --mount --mount-string="$HOME/.local/var/minikube:/mnt"

minikube start --profile=chemicals --driver=docker --addons=ingress,metrics-server --mount --mount-string="$HOME/.local/var/chemicals:/mnt"

minikube start --profile=petunia --driver=docker --addons=ingress,metrics-server --mount --mount-string="$HOME/.local/var/petunia:/mnt"
