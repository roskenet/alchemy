mkir -p ./mnt

minikube start \
    --driver=docker \
    --addons=ingress,metrics-server \
    --mount \
    --mount-string="./mnt:/mnt" 

