kubectl patch configmap tcp-services -n ingress-nginx --patch '{"data":{"6379":"default/redis:6379"}}'


kubectl patch deployment ingress-nginx-controller --patch "$(cat ingress-nginx-controller-patch.yaml)" -n ingress-nginx
