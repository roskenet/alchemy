kubectl config use-context minikube

kubectl scale --replicas=1 deployments/zookeeper
kubectl scale --replicas=1 deployment/kafka
kubectl scale --replicas=1 deployment/nakadi
