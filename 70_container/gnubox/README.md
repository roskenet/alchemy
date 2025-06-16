# Running this with pure docker:

```bash
docker build --build-arg HOST_UID=${UID} --build-arg HOST_GID=${GID} -t gnubox .
docker run -p 5901:5901 -v /home/froske/Workspaces/gnubox:/home/developer --name gnubox gnubox
```

