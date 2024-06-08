"""
[1,1,2,3,5,8....]
func(0)=1
func(1)=1
func(n)=func(n-1) + func(n-2) for n > 1

Advance: recursive function     recursion tree 
disadantage:  have overlapping at certain function, can memoroizting to improve performance

O()

top-down approach
"""
def fib(n):
    if n <=1: 
        return 1 
    else: 
        return fib(n-1)+fib(n-2)

for i in range(6):
    print(fib(i))