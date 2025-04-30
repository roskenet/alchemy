#!/usr/bin/env bash
export SONAR_TOKEN=sqp_8ee6165ee98cdb379eb007b693bb8b0f319cd4a2

./mvnw clean verify sonar:sonar \
  -Dsonar.projectKey=production-comments \
  -Dsonar.projectName='production-comments' \
  -Dsonar.host.url=http://sonar.192-168-49-2.nip.io \
  -Dsonar.token=sqp_8ee6165ee98cdb379eb007b693bb8b0f319cd4a2
