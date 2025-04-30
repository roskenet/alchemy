kubectl patch configmap tcp-services -n ingress-nginx --patch '{"data":{"9092":"default/kafka:9092"}}'
kubectl patch deployment ingress-nginx-controller --patch "$(cat ingress-nginx-controller-patch.yaml)" -n ingress-nginx
