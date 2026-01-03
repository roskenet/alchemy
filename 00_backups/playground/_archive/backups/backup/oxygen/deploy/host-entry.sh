# Add the host entry
# /etc/hosts
cp /etc/hosts /etc/hosts.bck && echo "$(minikube -p playground ip) oxygen.playground" >> /etc/hosts

