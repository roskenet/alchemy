'''
Created on Nov 13, 2019

@author: froske
'''
import typing

mystring = '''{{"production": 
                {{ "totalCount": {} }} 
              ,
              "test":
                {{ "totalCount" : {} }} 
              }}'''.format(21, 42)

print(mystring)

def do_something(name: str) -> str: 
   print("Hello World") 
   return "Hello"