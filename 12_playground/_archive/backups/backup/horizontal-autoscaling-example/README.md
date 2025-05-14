# Horizontal autoscaler example
## The Dockerfile

FROM php:5-apache
ADD index.php /var/www/html/index.php
RUN chmod a+rx index.php

## The php index
<?php
  $x = 0.0001;
  for ($i = 0; $i <= 1000000; $i++) {
    $x += sqrt($x);
  }
  echo "OK!";
?>

## The run command
kubectl run php-apache --image=k8s.gcr.io/hpa-example --requests=cpu=200m --expose --port=80
