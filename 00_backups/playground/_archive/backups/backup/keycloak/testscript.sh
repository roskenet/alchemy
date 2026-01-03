while [ $(curl -sL -w "%{http_code}\\n" "$(minikube -p playground ip):30111" -o /dev/null) != "200" ]
do
  sleep 2
done

echo "Jetzt bin ich hier!"


  
