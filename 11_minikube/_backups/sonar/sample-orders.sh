#!/usr/bin/env sh

export SONAR_PROJECT=sample-orders
export SONAR_TOKEN=sqp_13092b8286919446909079f98ca9502b32131567

sonar-scanner \
  -Dsonar.projectKey=$SONAR_PROJECT \
  -Dsonar.sources=. \
  -Dsonar.host.url=http://sonar.192-168-49-2.nip.io \
  -Dsonar.token=$SONAR_TOKEN

