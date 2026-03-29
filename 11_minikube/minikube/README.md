# Startup 

minikube start --driver=docker --addons=ingress,metrics-server --mount --mount-string="$HOME/.local/var/minikube:/mnt"

minikube ssh -- "echo '
vm.max_map_count=262144
fs.inotify.max_user_watches=524288
fs.inotify.max_user_instances=512
fs.inotify.max_queued_events=16384
' | sudo tee -a /etc/sysctl.conf && sudo sysctl -p"
