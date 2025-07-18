aws cloudformation deploy \
  --region=eu-central-1 \
  --template-file static-site-oac.yaml \
  --stack-name StaticSiteOAC \
  --parameter-overrides \
    HostedZoneName=felix-roske.de \
    Subdomain=static \
    CertificateArn=arn:aws:acm:us-east-1:310154938301:certificate/48d557bd-d94a-4012-b8e2-cb2dbd59e946 
