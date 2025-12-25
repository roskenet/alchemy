# A local nakadi for minikube

1. Build a nakadi jar
2. Build a nakadi container 
3. kubectl apply -f deployment.yaml , service.yaml, ingress.yaml
4. execute database script from nakadi sources dir

For step 4.: try to mount to /docker-entrypoint-initdb.d in the container.



To do something with it:

1. POST a subscription

2. GET from it: 
curl -v -XGET "http://nakadi.192-168-49-2.nip.io/subscriptions/038fc871-1d2c-4e2e-aa29-1579e8f2e71f/events"
