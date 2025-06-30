CLUSTER := petunia
DRIVER := docker
LOCAL_MOUNT := /home/felix/Workspaces/alchemy/20_poc/petunia/mount

.PHONY: start stop delete status

start:
	echo "Starting $(CLUSTER)..."
	minikube start -p $(CLUSTER) --driver $(DRIVER) --mount \
		--mount-string "$(LOCAL_MOUNT):/data" --cpus=2 \
		--addons ingress,metrics-server,dashboard,registry,ingress-dns

stop:
	echo "Stopping $(CLUSTER)..."
	minikube stop -p $(CLUSTER)

delete:
	echo "Deleting $(CLUSTER)..."
	minikube delete -p $(CLUSTER)

status:
	minikube status -p $(CLUSTER)


