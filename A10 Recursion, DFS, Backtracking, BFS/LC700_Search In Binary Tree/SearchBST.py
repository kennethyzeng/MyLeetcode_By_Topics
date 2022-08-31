# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution(object):
  def search(self, root, key):
    """
    input: TreeNode root, int key
    return: TreeNode
    """
    # write your solution here


#####Recursive approoach####
def recursive(self, root, val):
        def rec(root):
            if root:
                if root.val == val: return root
                elif root.val < val: return rec(root.right)
                return rec(root.left)
        
        return rec(root)


######iterative Approach#####
def iterative(self, root, val):
        temp = root
        while temp:
            if temp.val == val: return temp
            elif temp.val < val: temp = temp.right
            else: temp = temp.left
        return None