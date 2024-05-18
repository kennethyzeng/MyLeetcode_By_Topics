class Node: 
    """A Circular linked Node"""
    def __init__(self, data=None):
        self.data = data 
        self.next = None 

class CircularLinkedList:
    def __init__(self):
        self.tail=None  #pt to last node
        self.head = None #always pt to first node
        self.size = 0

    def append(self, data):
        node =Node(data)
        if self.tail:  #case 1: one or more than one node
            self.tail.next=node 
            self.tail=node 
            node.next=self.head
        else: #case 2: no node 
            self.head=node 
            self.tail=node 
            self.tail.next=self.tail 
        self.size += 1
    
    #need two extra pter: current and prev
    def delete(self, data):
        current=self.head 
        prev=self.head 
        flag = False #to determinte if the node exist 
        while prev==current or current==self.tail:
            if current.data == data:
                #condition 1: item to be deleted is head node  
                if current == self.head: 
                    


    def iter():
        pass 