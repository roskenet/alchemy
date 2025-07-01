eval $(minikube -p minikube docker-env)
cd nakadi
git pull origin master

cd -
docker build -t roskenet/nakadi:10.7.0 .
kubectl apply -f ../deployment.yaml

