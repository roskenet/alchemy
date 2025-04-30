kubectl config use-context minikube

kubectl scale --replicas=0 deployment/nakadi
kubectl scale --replicas=0 deployment/kafka
kubectl scale --replicas=0 deployments/zookeeper
