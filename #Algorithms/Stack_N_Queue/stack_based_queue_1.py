'''
Stack_based Queue Approach 1: 
    need two stack: 
        -stack1: treated like queue
        -stack2: help for transfer data from stack 1 to stack2, then back to stack1 
                when deque operation

Advantage and disadvantage
-Worst-time complexity is 0(1) for enqueue 
-Worst-time complxity is O(n) for dequeue
when have to design to use stack, need to ask user will use enqueue operion or dequeue operation more?
'''
class StackQueue:
    def __init__(self):
        self.stack1 =[]
        self.stack2 =[]
        self.size = 0; 

    def enqueue(self, data):
        self.stack1.append(data)
        #self.stack1.insert(0, data)
        self.size +=1

    def dequeue(self):
        if not self.stack2:  #stack2 is empty  
            while(self.stack1):
                self.stack2.append(self.stack1.pop())
            self.size -=1 
        if not self.stack2:
            print("No element to dequeue")
            return 
        pop_content=self.stack2.pop()

        while self.stack2:
            self.stack1.append(self.stack2.pop())
        
        return pop_content
    
    def qsize(self): 
       return self.size

#test 
#[5, 10, 7]    
#sart     end
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
