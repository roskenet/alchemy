psql -h $(minikube ip)  -U postgresadmin --password -p 32411 postgresdb

kubectl exec -it postgres-85b5f674d4-5skbw -- psql -h localhost -U postgresadmin --password -p 5432 postgresdb

Jetzt kann man den Server aus einem ubuntu pod aus erreichen:

kubectl exec -it ubuntu -- /bin/bash
psql -h postgres -U postgresadmin postgresdb
