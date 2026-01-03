'''
Created on Feb 28, 2020

@author: felix
'''

def sabb(s, value, happiness):
    search_chars = ["s","a","b","t","i","c","l"]
    
    score=0
    
    for letter in list(s):
        if letter in search_chars:
            score+=1 
    
    if score+value+happiness > 22:
        return "Sabbatical! Boom!"
    else:
        return "Back to your desk, boy."

sabb("Can I have a sabbatical?", 5, 5), "Sabbatical! Boom!"

sabb("Why are you shouting?", 7, 2), "Back to your desk, boy."

# def sabb(stg, value, happiness):
#     sabbatical = (value + happiness + sum(1 for c in stg if c in "sabbatical")) > 22
#     return "Sabbatical! Boom!" if sabbatical else "Back to your desk, boy."