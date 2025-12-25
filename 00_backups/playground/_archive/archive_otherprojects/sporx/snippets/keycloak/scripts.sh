function ktoken() {

echo $(curl --silent -d "client_id=admin-cli" -d "username=admin" -d "password=admin" -d "grant_type=password" "http://$(minikube -p playground ip):30111/auth/realms/master/protocol/openid-connect/token" | jq .access_token | sed -e 's/^"//' -e 's/"$//')

}
