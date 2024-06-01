class Node: 
    """
    A singly -linked Node 

    methods: 
    append at end 
    append at specific location 
        -first node 
        -any specif location 

    delete first node 
    delete last node 
    delete any specific location
    """
    def __init__(self, data=None):
        self.data = data 
        self.next = None 
    
class SinglyLinkedList:
    def __init__(self):
        self.head =None 
        self.tail=None   ##for faster append at the end
        self.size = 0
        

    def append(self,data):
        """append at end"""
        node = Node(data)
        if self.head == None: 
            self.head=node 
        else: 
            current=self.head 
            while current.next: 
                current=current.next 
            current.next=node 

    def faster_append(self,data):
        """faster append at the end with self.tail"""
        node = Node(data)
        if self.tail:
            self.tail.next = node 
            self.tail = node 
        else: 
            self.head = node 
            self.tail = node

    def append_at_a_location(self, data, index):
        """append at specific location"""
        current=self.head 
        prev=self.head 
        node=Node(data)
        count=1
        while current:
            #append at head 
            if index == 1: 
                node.next =current
                self.head = node 
                print(count)
                return 
            elif index==count:
                node.next=current   #
                prev.next=node  #
                return 
            count +=1
            prev = current 
            current = current.next 
        if count < index: 
            print("The list has less number of elements")

    def delete_first_node(self):
        current = self.head 
        if self.head == None:
            print("No data element to delete")
        else: 
            self.head = current.next 


    def delete_last_node(self):
        """delete the last node"""
        current =self.head 
        prev=self.head 
        while current: 
            if current.next is None: 
                prev.next= current.next 
                self.size -=1 
            prev = current 
            current=current.next 

    def delete(self, data):
        """delete the node with match data"""
        current=self.head 
        prev=self.head 
        while current:
            if current.data == data:
                if current == self.head:
                    self.head=current.next 
                else: 
                    prev.next=current.next 
                self.size -=1 
                return
            prev=current
            current=current.next 
            
    def iter(self):
        """list traversal singly list"""
        current=self.head 
        while current: 
            val=current.data
            current=current.next
            yield val

words=SinglyLinkedList()
words.append('egg')
words.append('ham')
words.append('spam')

current=words.head 
while current: 
    print(current.data)
    current=current.next 
print("#" * 26)

words.append_at_a_location("new", 2)
for word in words.iter():
    print(word)
print("#" * 26)

words.delete_first_node()
words.delete_last_node()
words.delete('ham')

for word in words.iter():
    print(word)
print("#" * 26)