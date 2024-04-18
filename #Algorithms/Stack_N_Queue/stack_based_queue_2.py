'''
Stack_based Queue Approach 2: 
    need two stack: 
        -stack1: treated like queue
        -stack2: help for transfer data from stack 1 to stack2, then back to stack1 
                when deque operation

Advantage and disadvantage
-Worst-time complexity is 0(1) for dequeue
-Worst-time complxity is O(n) for enqueue
when have to design to use stack, need to ask user will use enqueue operion or dequeue operation more?
'''
class StackQueue:
    def __init__(self):
        self.stack1 =[]    #treated like stack
        self.stack2 =[]
        self.size = 0; 

    def enqueue(self, data):
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        self.stack2.append(data)
        self.size += 1

        while self.stack2: 
            self.stack1.append(self.stack2.pop())

    def dequeue(self):
        if not self.stack1:   #stack1 is empty
            return "No element to dequeue"
        if self.stack1: 
            self.size -=1
            return self.stack1.pop(0)    
        
    
    def qsize(self): 
       return self.size

#test 
queue = StackQueue()
queue.enqueue(5)
queue.enqueue(10)
queue.enqueue(7)
print(queue.stack1)


print(queue.dequeue())
print(queue.stack1)
print(queue.dequeue())
print(queue.stack1)

queue.enqueue(18)
print(queue.stack1)
print(queue.qsize())
