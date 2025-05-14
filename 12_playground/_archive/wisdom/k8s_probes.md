...
spec:
  containers:
  - …
    startupProbe:
      httpGet:
        path: /actuator/health/liveness
        port: 8080
        initialDelaySeconds: 10
        periodSeconds: 5
    livenessProbe:
      httpGet:
        path: /actuator/health/liveness
        port: 8080
        initialDelaySeconds: 1
        periodSeconds: 3
    readinessProbe:
      httpGet:
        path: /actuator/health/readiness
        port: 8080
        initialDelaySeconds: 5
        periodSeconds: 2
 
[Source: Java Magazing, 5.2024, Thomas Kruse, "17 Toptipps aus der Praxis für bessere Anwendungen mit Kubernetes"]
