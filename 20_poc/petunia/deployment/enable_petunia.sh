conda activate petunia
eval $(minikube -p petunia docker-env)

function pkubectl() {

    minikube -p petunia kubectl $@

}

function pminikube() {

    minikube -p petunia $@

}
