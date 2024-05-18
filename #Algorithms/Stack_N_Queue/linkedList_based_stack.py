"""
stack built by singly linked list 
    -variable top is to locate the item on the top of stack, which is always first node 

need to ask intervier the size of stack..is the data big or small or unknown
you can decide to choose to build with array or linkedlist 
"""
class Node:    
    def __init__(self, data=None):
        self.data=data 
        self.next=None

class LinkedListStack:
    def __init__(self):
        self.top=None 
        self.size = 0

    def push(self,data):
        node=Node(data)
        if self.top:
            node.next=self.top
            self.top=node 
        else:
            self.top =node 
        self.size +=1 
    
    def pop(self):
        if self.top:
            data=self.top.data
            size -=1
            if self.top.next:  #case 1: more than one node 
                self.top=self.top.next
            else:  #case 2: only one node left
                self.top = None
            return data
        else:  #case 3: empty 
            print("Stack is empty")


    def peek(self):
        if self.top: 
            return self.top.data 
        else: 
            print("It is empty stack")

#cases validation
words=LinkedListStack()
words.push("egg")
words.push("ham")
words.push("spam")

current=words.top 
while current: 
    print(current.data)
    current=current.next
print("#"*16 + "\n")
words.pop()

current=words.top 
while current: 
    print(current.data)
    current=current.next 

words.peek()
