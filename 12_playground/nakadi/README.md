# Nakadi Playground

## Run docker image

docker run --name nakadi --rm -d -p 9191:8080 roskenet/scnakadi:0.0.12

## Create event-type

```sh

curl -v -XPOST "http://localhost:9191/event-types" -H "Content-type: application/json" -d '{
  "name": "music.artist",
  "owning_application": "order-service",
  "category": "undefined",
  "partition_strategy": "random",
  "schema": {
    "type": "json_schema",
    "schema": "{ \"properties\": { \"name\": { \"type\": \"string\" } } }"
  }
}'  
```

## Create subscription

```sh
curl -v -XPOST "http:///nakadi.minikube/subscriptions" -H "Content-type: application/json" -d '{
    "owning_application": "order-service",
    "event_types": ["minikube.TEST"]
  }'  
```

The id is a UUID: 
e9c778d3-d0cd-4db7-b5fa-96ec3cdb1d9d

## Listen to it

```sh
curl -v -XGET "http://localhost:8080/subscriptions/038fc871-1d2c-4e2e-aa29-1579e8f2e71f/events"
```

```sh
curl -XPOST "http://nakadi.minikube/event-types/minikube.TEST/events" -H "Content-Type: application/json" -d '[{
  "name": "Elvis A. Presley"
}]'
```sh

## Commit the cursor

```sh
curl -v -XPOST "http://nakadi.minikube/subscriptions/e9c778d3-d0cd-4db7-b5fa-96ec3cdb1d9d/cursors"\
  -H "X-Nakadi-StreamId: 1888b92d-d4d8-4810-b3df-76600ef793d3" \
  -H "Content-type: application/json" \
  -d '{
    "items": [
      {
        "partition": "0",
        "offset": "001-0001-000000000000000001",
        "event_type": "minikube.TEST",
        "cursor_token": "b75c3102-98a4-4385-a5fd-b96f1d7872f2"
      }
    ]
  }'
```
