#!/usr/bin/env python
import requests

def doSomething():
    print('Hello World!')
    response = requests.get('http://oxygen.192-168-49-2.nip.io/api/name/Felix Roske')

    print(response.json())

if __name__ == '__main__':
    doSomething()
