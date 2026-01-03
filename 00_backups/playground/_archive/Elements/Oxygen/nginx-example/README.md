# NGINX startup

```bash
docker run --name my-nginx -v $PWD/content:/usr/share/nginx/html:ro -p 8080:80 -d nginx
```
