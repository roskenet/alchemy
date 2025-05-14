#!/usr/bin/env python
import subprocess
import json

def get_pods():
    output = subprocess.run(['kubectl', 'get', 'pods', '-o', 'json'], stdout=subprocess.PIPE).stdout.decode('utf-8')

    result = json.loads(output)

    print(result['apiVersion'])

    for i in result['items']:
        print(i)

if __name__ == '__main__':
    get_pods()

