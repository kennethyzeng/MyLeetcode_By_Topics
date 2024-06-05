def factorial(x):
    if x == 0: 
        return 1 
    else: 
        return x * factorial(x-1)
    
print(factorial(4))

"""
4*3*2*1*1
"""