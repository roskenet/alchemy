# Only needed when you want to access zookeeper from your host for other things

kubectl patch configmap tcp-services -n ingress-nginx --patch '{"data":{"2181":"default/zookeeper:2181"}}'
kubectl patch deployment ingress-nginx-controller --patch "$(cat ingress-nginx-controller-patch.yaml)" -n ingress-nginx
