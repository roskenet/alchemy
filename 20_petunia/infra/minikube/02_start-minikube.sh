mkir -p ./mnt

minikube start \
    --driver=docker \
    --addons=ingress \
    --mount \
    --mount-string="./mnt:/mnt" \
    --cpus=2 \
    --memory=8192

