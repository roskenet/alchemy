kubectl apply -f keycloak-namespace.yaml

minikube -p playground ssh "sudo mkdir -p /data/vol001"
kubectl apply -f database-pv.yaml
kubectl apply -f database-pvc.yaml

kubectl apply -f database-deployment.yaml
kubectl apply -f database-service.yaml

kubectl apply -f keycloak-deployment.yaml
kubectl apply -f keycloak-service.yaml

source ./scripts.sh

while [ $(curl -sL -w "%{http_code}\\n" "$(minikube -p playground ip):30111" -o /dev/null) != "200" ]
do
  echo "Waiting for keycloak being up and running..."
  sleep 2
done

curl -i -X POST \
  -H "Content-Type: application/json" -H "Authorization: Bearer $(ktoken)" \
  -d @playground.json http://$(minikube -p playground ip):30111/auth/admin/realms

