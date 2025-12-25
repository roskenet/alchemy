'''
Created on Mar 1, 2020

@author: felix
'''
import fractions

cache = {}

def coeff(n, k):

    if(2 * k > n):
        k = n - k
    
    if cache.get(n) != None:
        if cache.get(n).get(k) != None:
            return cache.get(n).get(k)

    result = fractions.Fraction(1)
    for i in range(1, k+1):
        temp = fractions.Fraction((n - k + fractions.Fraction(i)) / fractions.Fraction(i)) 
        result = result * temp

    result = fractions.Fraction(1)
    for i in range(1, k+1):
        result = result * fractions.Fraction((n - k + i),i)
    
    if cache.get(n) == None:
        cache[n] = {}

    cache[n][k] = result
    return result

def diagonal(n, p):
    return coeff(n+1, p+1)


print(diagonal(20, 5)) #Should be 54264

#print(coeff(14,5))
