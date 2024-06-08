"""
Check a given express containing bracket --{},(),[] -- is balance or not
"""
from stack import LinkedListStack

def check_brackets(expression):
    bracket_stack=LinkedListStack()
    last =' '

    for ch in expression:
        if ch in ('(', '[','{'):
            bracket_stack.push(ch)
            
        if ch in (')', ']','}'):
            last=bracket_stack.pop()
            if last =="(" and ch==")":
                continue
            elif last =="[" and ch=="]":
                continue
            elif last =="{" and ch=="}":
                continue
            else: 
                return False 
    
    if bracket_stack.size > 0:
        return False 
    else: 
        return True
    
sl = (
"{(foo)(bar)}[hello](((this)is)a)test",
"{(foo)(bar)}[hello](((this)is)atest",
"{(foo)(bar)}[hello](((this)is)a)test))"
)
for s in sl:
    m = check_brackets(s)
    print("{}: {}".format(s, m))
    

