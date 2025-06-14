# Executable jar

```sh
echo '#!/bin/sh
exec java -jar "$0" "$@"' > myapp
cat yourfile.jar >> myapp
chmod +x myapp
```
