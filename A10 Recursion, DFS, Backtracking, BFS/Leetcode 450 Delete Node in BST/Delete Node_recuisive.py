# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
        if not root: 
            return 
    
        if root.val > key: 
            root.left = self.deleteNode(root.left, key)
        elif root.val < key: 
            root.right = self.deleteNode(root.right, key)
        else: 
            if not root.left: 
                return root.right
            else: 
                tmp = root.left
                while tmp.right: 
                    tmp = tmp.right
                root.val = tmp.val 
                root.left = self.deleteNode(root.left, tmp.val)
        return root


######################Recursive above; 