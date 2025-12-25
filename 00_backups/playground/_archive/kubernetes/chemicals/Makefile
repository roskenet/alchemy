all: .postgres

.postgres:
	kubectl apply -f postgres/postgres-configmap.yaml
	kubectl apply -f postgres/postgres-storage.yaml
	kubectl apply -f postgres/postgres-deployment.yaml
	kubectl apply -f postgres/postgres-service.yaml

.servicepod:
	echo "Hello servicepod"

clean:
	kubectl delete pod servicepod --ignore-not-found=true
	kubectl delete deployment oxygen --ignore-not-found=true
	kubectl delete service oxygen --ignore-not-found=true
	kubectl delete ingress oxygen --ignore-not-found=true
	kubectl delete deployment camunda --ignore-not-found=true
	kubectl delete service camunda --ignore-not-found=true
	kubectl delete ingress camunda --ignore-not-found=true
	kubectl delete deployment keycloak --ignore-not-found=true 
	kubectl delete service keycloak --ignore-not-found=true
	kubectl delete ingress keycloak --ignore-not-found=true
	kubectl delete deployment postgres --ignore-not-found=true
	kubectl delete service postgres --ignore-not-found=true
	kubectl delete pvc postgres-pv-claim --ignore-not-found=true
	kubectl delete pv postgres-pv-volume --ignore-not-found=true
	kubectl delete configmap postgres-config --ignore-not-found=true

