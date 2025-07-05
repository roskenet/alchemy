# Get a token:

export TOKEN=`curl -X POST http://keycloak/realms/petunia/protocol/openid-connect/token \
  -d "grant_type=client_credentials" \
  -d "client_id=villadiana" \
  -d "client_secret=6w8HibfpYVEQIgMTKAFXFPMC8NgaOHBU" \
  -d "scope=petunias.read petunias.write" | jq -r .access_token`

