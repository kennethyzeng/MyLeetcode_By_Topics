"""
in order traversal : L root R
pre order traversal : root L R
post order traversal : L R root
"""

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

current = n1 
while current: 
    print(current.data)
    current=current.left_child 
print("\n")
##############

def inorder(root_node):
    current=root_node 
    if current is None: 
        return 
    inorder(current.left_child)
    print(current.data)
    inorder(current.right_child)

def preorder(root_node):
    current=root_node
    if current is None:
        return 
    print(current.data)
    preorder(current.left_child)
    preorder(current.right_child)

def postorder(root_node):
    current=root_node 
    if current is None:
        return 
    postorder(root_node.left_child)
    postorder(root_node.right_child)
    print(current.data)

inorder(n1)
print("#"*20,"\n")
preorder(n1)
print("#"*20,"\n")
postorder(n1)