"""
stack built by array(FILO)-first in last out
    -need to set size of array
    -idx 0 is first item(begin), idx(top) is last item(end)
need three function: push(), pop(), pee()
"""

size =3 
data = [0]* (size) #initialize the stack 
top=-1   #index pter to first position of stack; help for peek() and pop() for positional location

def push(x):
    global top 
    if top >= (size -1):
        print("Stack overflow")
    else:
        top +=1
        data[top]=x

def pop():
    global top 
    if top == -1: 
        print("Stack unferflow")
    else: 
        tmp=data[top]
        data[top]=0
        top -=1
        return tmp
    
def peek():
    global top 
    if top == -1:
        print("Stack is empty")
    else: 
        print(data[top])


####cases validation
push('egg')
print(data) 
push('ham')
print(data)
push('spam')
push('new')
push('new2')
print(data)
print(data[0: top +1])
print("="*12+"\n")

a=pop()
print(a)
print(data)
peek()
a=pop()
print(a)
print(data)
pop()
pop()
print("="*12+"\n")

peek()

print(data[0:top+1])