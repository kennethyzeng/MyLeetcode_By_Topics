"""
Circular linked list: 
    -tail.next = head 
    -need self.head and self.point 
    -two method: append(), and delete()
    -for the delete(), need one while loop with two pointer: prev and current
"""
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
        current=self.head #pt 1
        prev=self.head    #pt 2
        flag = False #to determinte if the node exist 
        while prev==current or prev!=self.tail:  #iteration
            if current.data == data:
                #condition 1: item to be deleted is head node  
                if current == self.head: 
                    self.head=current.next 
                    self.tail.next =self.head 
                #contition 2: item to be deleted is tail node
                elif current == self.tail:
                    self.tail = prev 
                    prev.next=self.head 
                #condition 3: item to be deleted is intermdeiate node 
                else: 
                    prev.next =current.next 
                self.size -=1 
                return   #not correct if miss this one
            prev = current 
            current = current.next 
        if flag is False: 
            print("Item not present in the list")


    def iter(self):
        current = self.head 
        while current:
            val =current.data 
            current=current.next 
            yield val 

#case validation
words =CircularLinkedList()
words.append("ham")
words.append("Spam")
words.append("egg")


"""
counter=0 
for word in words.iter():
    print(word)
    counter += 1 
    if counter >2:
        break 
print("*" * 16)
"""
words.append('foo')
words.append('bar')
words.append('bim')
words.append('baz')
words.append('quux')
words.append('duux')

print('Let us delete something that is there.')
#words.delete('ham')
#words.delete('bar')
words.delete('duux')
#words.delete('socks')
print('back to iterating')
counter = 0
for item in words.iter():
    print(item)
    counter += 1
    if counter == 9:
        break