'''
FIFO
Three feature: 
    -enqueue 
    -dequeue 
    -size

Approach: 
Implemented with boubly linked list. 
    -advantage: doulby linked list is more efficient than singly linked list. 
            Singly linked list's time complexity is large for large data
        NOte: Not ture. If the singly linked list use two pointers. it is same as dbouly linked list. 
            It is true only the singly linked list have only one pointer. self.head
    -two pointer 
        the head pointer: pt to the start of queue 
        the tail pointer: pt to the end of queue 
'''
class Node(object):
    '''
    double linked list
    '''
    def __init__(self, data=None, next=None):  #remove prev=None
        self.data = data 
        self.next = next
        #self.prev = prev 

class Queue:
    def __init__(self):
        self.head=None
        self.tail=None 
        self.count = 0 

    #worst-time complexity for enqueue is O(1)
    def enqueue(self, data): 
        new_node=Node(data, None)   ##
        if self.head==None:
            self.head= new_node
            self.tail=self.head 
        else:
            #new_node.pre=self.tail
            self.tail.next=new_node 
            self.tail=new_node
        self.count += 1 

    def dequeue(self):  #concept of FIFO
        if self.count ==1:
            content=self.head.data  #add from original code
            self.next=None 
            self.head = None
            self.count -= 1
            return content # add from original code
        elif self.count > 1:    #FIFO 
            content=self.head.data
            self.head= self.head.next 
            #self.head.pre = None
            self.count -= 1
            return content
        elif self.count < 1: 
           # print("Queue is empty")
            return "Queue is empty"
        #self.cout -= 1

    def size(self):
        return self.count    

#test     
q=Queue()
q.enqueue(4)
q.enqueue("Dog")
q.enqueue("True")
print(q.count)
data1=q.dequeue()  
print(data1)   #4
print(q.size())
    
