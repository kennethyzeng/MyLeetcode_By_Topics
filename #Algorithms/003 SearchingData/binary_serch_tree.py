"""
BST feature:
    -value at any node in the trees is greater than the value in all the node of its left subtress 
    -less than(or equal to ) the values of all the nodes of the right subtree 
        left <= root <= right

BST operatoin: 
    -insert 
    -delete 
    -finding min 
    -finding max
    -search

insert function: 
    -if empty, insert 
    -if not empty, compare data with current node. data, then decide to go left leg or right leg. 
    -insert node at the end (when reach leaf node)

search function: 
    -if empty, not found 
    -compare current.data with data, if less, go left leg; otherwise go right leg. until the data is found 

findMin function 
    -keep interation to left_child until current.left_child is None

findMax function:
    -keep interation to right_child of current node untile current.right_child is None

deletion function:

"""

class Node: 
    def __init__(self,data=None):
        self.data = data 
        self.left_child= None 
        self.right_child=None 

class BST:
    def __init__(self):
        self.root_node = None 

    def insert(self, data):
        """insert a node at the end and meet BST guileline"""
        #condition 1: if empty tree 
        node=Node(data)
        if self.root_node is None: 
            self.root_node = node 
            return self.root_node 
        else: 
            current = self.root_node
            parent = None 
            while True: #interation 
                parent = current 
                if node.data < parent.data:
                    current = current.left_child
                    if current is None: 
                        parent.left_child = node 
                        return self.root_node
                else: 
                    current = current.right_child
                    if current is None: 
                        parent.right_child = node 
                        return self.root_node 

    def inorder(self,root_node):
        current = root_node
        if current is None: 
            return 
        self.inorder(current.left_child)
        print(current.data)
        self.inorder(current.right_child)

    def get_node_with_parent(self, data):
        """return the node with matched data and its parent node"""
        parent = None 
        current=self.root_node 
        if current is None: 
            return (parent, None)
        while True: 
            if current.data == data: 
                return (parent, current)
            elif (current.data > data):
                parent = current 
                current=current.left_child 
            else: 
                parent = current 
                current=current.right_child 
        #return (parent, current)   ##No nessary? since already return above; should consider the case of not match data
        return "Not such node matched data"

    def search(self, data):
        current = self.root_node 
        #print(current.data)
        while True: 
            if current is None: 
                print("Item not found")
                return None 
            elif current.data == data:
                print("Item found", data)
                return data
            elif current.data > data:
                current = current.left_child 
            else: 
                current = current.right_child 

    def findMin(self):
        current = self.root_node 
        while current.left_child:
            current = current.left_child 
        return current.data

    def findMax(self):
        current =self.root_node 
        while current.right_child: 
            current = current.right_child 
        return current.data

    #most cmplicated concept
    def delete(self,data):
        #step 1: search matched Node and its parent node
        parent, node =self.get_node_with_parent(data)
        #condition: empty tree
        if parent is None and node is None: 
            return False

        #Step 2 determinte the children of match node     
        children_count = 0    #Get children count

        if node.left_child and node.right_child: 
            children_count = 2 
        elif (node.left_child is None and node.right_child is None):
            children_count = 0 
        else: 
            children_count = 1
        
        #step 3:
        #condition 1: no childrend for matched node
        if children_count == 0:
            if parent: 
                print(parent.data)
                if parent.right_child is node: 
                    parent.right_child = None 
                else: 
                    parent.left_child is None
            else: 
                self.root_node = None     ##??
        #condition 2: one child 
        elif children_count == 1:
            next_node =None 
            if node.left_child:
                next.node=node.left_child 
            else: 
                next_node = node.right_child 
            
            if parent: 
                if parent.left_child is node: 
                    parent.left_child = next_node 
                else: 
                    parent.right_node = next_node   
            else: 
                self.root_node = next_node  ##?
        #condition 3: two children 
        else: 
            parent_of_leftmost_node = node 
            leftmost_node = node.right_child
            #traversal to leftmost left of right child of the parent node(deleted node); and make that data to replace deleted node's data 
            while leftmost_node.left_child: 
                parent_of_leftmost_node=leftmost_node 
                leftmost_node = leftmost_node.left_child 
            node.data = leftmost_node.data

            if parent_of_leftmost_node.left_child == leftmost_node: 
                parent_of_leftmost_node.left_child = leftmost_node.right_child 
            else: 
                parent_of_leftmost_node.right_child = leftmost_node.right_child 


tree = BST()
r = tree.insert(5)  #r is root 
r = tree.insert(2)
r = tree.insert(7)
r = tree.insert(9)
r = tree.insert(1)

#print(tree.findMin())
#print(tree.findMax())
#tree.inorder(r)

##tree.search(9)

tree.delete(9)
tree.inorder(r)
tree.search(9)