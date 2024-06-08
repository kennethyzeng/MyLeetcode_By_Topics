"""
Expression tree
    -is speical kind of binary tree that's used to represent arithmetic expression 
    -combination of operator and operands:   operator can be unary or binary 

postfix  => use postorder traversal methodology
- or call "reverse polish notation" RPN

Examples:
3 4 +        => 3+4
3 4 + 5 -   => (3 +4) - 5
4 5 + 5 3 - *   => (4 +5)* (5-3)
A B C * + D +     =>A+B *C +D
Approach: 
Step 1:
-use stack to push numbers. 
-when read operator, pop two numbers to executre operation. and make left and right connection to the operatro node
-the result is push back to stack 
-keep interation until end of string 
===> binary tree is form 

Step 2: 
use recursion to calulate value 

---
stack class 
node class 
cal function for recursion 
stack logic to build binary tree 

"""

class Stack: 
    def __init__(self):
        self.elements=[]
    
    def push(self, item):
        self.elements.append(item)

    def pop(self):
        return self.elements.pop()

class TreeNode:
    def __init__(self, data=None):
        self.data = data 
        self.left=None 
        self.right=None 

##recursion 
def calc(node):
    if node.data == "+": 
        return calc(node.left) + calc(node.right)
    elif node.data == "-":
        return calc(node.left) - calc(node.right)
    elif node.data== "*":
        return calc(node.left) * calc(node.right)
    elif node.data== "/":
        return calc(node.left) / calc(node.right)
    else: 
        #base 
        return node.data
    
expr="4 5 + 5 3 - *".split() 
stack = Stack()

##stack logic 
for term in expr: 
    """
    1. if number, stack.push()
    2. if +-*/, stack.pop(), then make that node have left and right child related to pop value, finally stack.push +_*/ node 
    3. finally stack have nodes with data of +-*/
    """
    if term in "+-*/":
        node =TreeNode(term)
        #print(node.data)
        #print(stack.elements)
        node.right=stack.pop()
        node.left=stack.pop()
    else: 
        node = TreeNode(int(term))   #change from string to int
    stack.push(node)

root = stack.pop()
result = calc(root)
print(result)
