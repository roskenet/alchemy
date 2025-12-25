#!/usr/bin/env python3

import subprocess
import io

process = subprocess.Popen(['ls', '-la'],
        stdout=subprocess.PIPE,
        stderr=subprocess.STDOUT)

stdout,stderr = process.communicate()
output = stdout.decode("utf-8")

for i in output.split("\n"):
    print(i)

