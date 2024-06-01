"""
Doubly linked List 
Methods: 
    -append at start
    -append at end 
    -append at specific location 

    -delete 
        -at first node 
        -at last node 
        -at specific position 
        -no found 
    Note: when delete, do you delete one item or all found item with matched data
    ask such question 
"""
class Node:
    def __init__(self, data=None, next=None, prev=None):
        self.data=data 
        self.next = next  
        self.prev = None 
    
class DoublyLinkedList:
    def __init__(self): 
        self.head=None 
        self.tail=None 
        self.size = 0

    def append_at_start(self,data):
        """append an item at beginning to the list"""
        new_node=Node(data, None, None)
        if self.head ==None: 
            self.head = new_node
            self.tail= self.head
        else: 
            new_node.next=self.head 
            self.head.prev=new_node 
            self.head = new_node 
        self.size +=1

    def append(self, data):
        """append at the end of the list"""
        new_node=Node(data, None, None)
        if self.head is None: 
            self.head = new_node 
            self.tail= new_node 
            
        else: 
            self.tail.next=new_node 
            new_node.prev=self.tail 
            self.tail=new_node 
        self.size +=1            

    def append_at_a_location(self, data):
        """insert a node to specific loation with matched data"""
        """word to append at start, end, and any specific location"""
        """also, consider at specific index method (self, data, index)"""
        current =self.head
        prev=self.head 
        new_node = Node(data, None, None)
        flag=False
        while current: 
            if current.data ==data:
                new_node.prev = prev 
                new_node.next = current 
                prev.next = new_node 
                current.prev=new_node 
                flag = True 
                self.size +=1
            prev = current 
            current = current.next 
        #case: no match data
        if flag == False: 
            print("no matched data at list to append")
    
    def delete(self, data):
        """applying return after found, it only delete one found item; otherwise, it will delete all found items"""
        """can apply while at beginnning after current is None"""
        #conditions: empty list, first node, last node, at specific position, no found 
        current = self.head 
        node_deleted=False 
        if current is None: 
            print("list is empty")
        elif current.data == data:   #data found at first node
            self.head.prev = None 
            node_deleted=True 
            
            self.head=current.next 
        elif self.tail==data: 
            self.tail=self.tail.prev
            node_deleted=True 
            self.tail=None 
        else: 
            while current:   #other option, move this almost at the beginning if remove all matched data with applying return
                if current.data==data: 
                    current.prev.next = current.next 
                    current.next.prev = current.prev 
                    node_deleted=True 
                current=current.next 
            if node_deleted  == False: 
                print("item is not found ")
        if node_deleted:
            self.size -= 1



    def iter(self):
        current = self.head 
        while current: 
            val = current.data 
            current = current.next 
            yield val 
        
    def contains(self, data):
        """check if specific data in the list"""
        for node_data in self.iter():
            if data== node_data: 
                print("data item is presend in the list")
                return 
            
        print("data item is not present in the list")
        return 

####cases validation 
words = DoublyLinkedList()
words.append('egg')
words.append('ham')
words.append('spam')

for word in words.iter():
    print(word)
print("#" * 19+'\n')

words.append_at_start('begin')
words.append_at_a_location('ham')
for word in words.iter():
    print(word)
print("#" * 19+'\n')

words.contains('ham')
words.contains('egg')
print("#" * 19+'\n')

words.delete('ham')
for word in words.iter():
    print(word)