"""
remind: Minheap is completed binary tree
MinHeap implementation 

insert function 
    -add element to the end of the list 
    -after each insertion operation, arrange the new element up in the heap tree to satisfied the heap property 
        arrange() function ==> helper function

delete at root function 
    -helper functions
    mildchild function: find out which of children to compare against the parent node 
    sink function: percolate down process 
    -delete at root function -logic 
    """
class minHeap:
    def __init__(self):
        self.heap = [0]
        self.size = 0 
    
    def arrange(self, k):
        """
        rearrange nodes with instered node in order to meet minheap property 
        """
        while k // 2 > 0:
            if self.heap[k] < self.heap[k//2]:
                self.heap[k],self.heap[k//2] = self.heap[k//2], self.heap[k]   #swap between partent node and child node 
            k //= 2
    
    def insert(self, item):
        self.heap.append(item)
        self.size +=1
        self.arrange(self.size)

    def sink(self, k):
        """
        percolate down process 
        reorganize
        """
        while k * 2 <= self.size:
            mc = self.minchild(k)
            if self.heap[k] > self.heap[mc]:
                self.heap[k], self.heap[mc] = self.heap[mc],self.heap[k]  ##swap
            k = mc   ##down down

    def minchild(self, k):
        """
        to find out which of the children to compare against the parent node
        to know which of the lft or right children to compare against 
        locate the smaller value 
        """
        
        if k * 2 + 1 > self.size:  ##end of the list
            return k * 2
        elif self.heap[k * 2] < self.heap[ k * 2 +1 ]:  ##index of two childrend
            return k * 2
        else: 
            return k * 2 +1 

    def delete_at_root(self):
        item = self.heap[1]
        #self.heap[1]=self.heap[self.size]
        print(self.heap)
        self.size -= 1 
        self.heap.pop()
        #print(self.heap)
        self.sink(1)
        return item 
    
    def delete_at_location(self, location):
        """
        location: index
        """
        item = self.heap[location]
        self.heap[location]=self.heap[self.size]
        self.size -= 1
        self.heap.pop()
        self.sink(location)
        return item

h = minHeap()
for i in (4, 8, 7, 2, 9, 10, 5, 1, 3, 6):
    h.insert(i)

print(h.heap)
print("#" * 20)

n = h.delete_at_root()
print(n)
print(h.heap)
print("#" * 20)

n = h.delete_at_location(6)
print(n)
print(h.heap)