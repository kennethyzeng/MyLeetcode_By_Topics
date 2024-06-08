"""
BFT is level_order traversal 
root is level 0
need enqueu feature of Queue (FIFO) by implemented by deque 
    -left side is begin of people line. use popleft for first out 
    -right side is end of peopel line. use append to First in  

also need a list to store nodes' data from top down

time complexity O(n)
"""
from collections import deque

class Node: 
    def __init__(self, data):
        self.data = data 
        self.left_child=None 
        self.right_child =None 

n1=Node("root node")
n2=Node("left child Node")
n3=Node("right child Node")
n4=Node("left grandchild Node")

n1.left_child=n2 
n1.right_child =n3 
n2.left_child=n4


def levelOrderTraversal(rootNode):
    list_nodes=[]
    traversal_queue=deque([rootNode])

    while len(traversal_queue)>0:  #since keep appending nodes, won't terminate until last one
        node=traversal_queue.popleft()
        list_nodes.append(node.data)

        if node.left_child:
            traversal_queue.append(node.left_child)
        if node.right_child:
            traversal_queue.append(node.right_child)
    
    return list_nodes

print(levelOrderTraversal(n1))

