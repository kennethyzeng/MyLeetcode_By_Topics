# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        output = []
        self.inOrder(root, output)     ##After Inorder, output array is [6,3, 2, 5,1]
        
        for i in range(1, len(output)):
            if output[i-1] >= output[i]:
                return False
        return True
        
    def inOrder(self, root, output):
        #Base
        if root == None: 
            return
        
        self.inOrder(root.left, output)
        output.append(root.val)
        self.inOrder(root.right, output)