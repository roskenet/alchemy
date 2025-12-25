To expose other ports than 80 or 443 via nginx see:

https://minikube.sigs.k8s.io/docs/tutorials/nginx_tcp_udp_ingress/

1.
kubectl patch configmap tcp-services -n ingress-nginx --patch '{"data":{"5432":"default/postgres:5432"}}'

2. verify:
kubectl get configmap tcp-services -n ingress-nginx -o yaml

3. ingress-nginx-controller-patch.yaml
kubectl patch deployment ingress-nginx-controller --patch "$(cat ingress-nginx-controller-patch.yaml)" -n ingress-nginx

