###########Link source###############


#############Python Version###########

class TreeNode:
    #def __iniit__(self, val= 0, left=None, right=None):
    #    self.left = left
    #    self.right = right
    #    self.val = val
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
    
class Soluction:
    def isBalanced(self, root: [TreeNode])->bool:   #def isBalanced(self, root):
        pass
        
    ##Deriver code
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.left = TreeNode(4)
    root.left.right = TreeNode(5)
    root.right.left = TreeNode (6)
    root.right.right = TreeNode(7)
    print(root.right.right.val)