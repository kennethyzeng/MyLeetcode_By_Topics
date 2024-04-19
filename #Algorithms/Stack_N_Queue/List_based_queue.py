'''
FIFO 
Queue implemented by list. 
    -use insert(idx, data) for enqueue; don't use append(), it add to end of list
    -use pop(0) for deueue 
    -set maximum size, need two pointer
    -size of the list


Adv and disAdv
-enqueue and dequeue's time complexity should be O(1)
-since the size of list is fixed, it is not good for large or unknown data

'''
class ListQueue: 
    def __init__(self):
        self.items=[]
        self.front=self.rare=0
        self.size=5  #maximum capacityof the queue

    def enqueue(self, data):
        if self.size ==self.rare: 
            print("\nThe queue is full")
        else: 
            self.items.append(data)  
            #self.items.insert(0,data)   #is use insert(), it is stack function
            self.rare +=1    

    def dequeue(self):
        if self.front == self.rare: 
            print("Queue is empty")
        else: 
            data=self.items.pop(0)  #delete the item from front end of the queue 
            self.size -=1
            return data
    def qsize(self):
        return self.size

#test 
q = ListQueue() 
q.enqueue(5)
q.enqueue("hello")
q.enqueue("40")
q.enqueue(50)
q.enqueue(60)
#q is full
q.enqueue(80) #do nothing with this data; not enqueue

b = q.qsize()
print(b)
print(q.items)

data=q.dequeue()
print(data)
print(q.items)
