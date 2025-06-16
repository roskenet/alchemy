# Docker basics

Here's the workflow:

1. Create your container once:
   ```bash
   docker run -it --name my_persistent_container ubuntu bash
   ```

2. When you're done, exit the container (which stops it)

3. Later, to restart the same container with its state preserved:
   ```bash
   docker start -i my_persistent_container
   ```

The `-i` flag makes it interactive so you can use the command line.

This way, any files you created, packages you installed, or configurations you changed will persist between restarts.

