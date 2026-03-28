# Start a minikube

minikube start --profile=chemicals --driver=docker --addons=ingress,metrics-server --mount --mount-string="$HOME/Temp/mnt-chemicals:/mnt"

