"""
This stack is used to be called from other module
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
            self.size -=1
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