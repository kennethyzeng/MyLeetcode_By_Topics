#######one fast solution#####
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # Recursive
    # Linear time and space
    def binaryTreePaths(self, root):
        if not root:
            return []
        
        # Check leaf
        if not root.left and not root.right:
            return [str(root.val)]
        
        leftPath = self.binaryTreePaths(root.left)
        rightPath = self.binaryTreePaths(root.right)
        
        leftPath = [str(root.val) + '->' + path for path in leftPath]
        rightPath = [str(root.val) + '->' + path for path in rightPath]
        
        return leftPath + rightPath
    



#######DFS Recursively#######
Runtime: 64 ms, faster than 5.09% of Python3 online submissions for Binary Tree Paths.
#############################


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        if not root:
            return []
        res = []
        self.dfs (root, "", res)
        return res 
    
    def dfs(self, root, ls, res):
        if not root.left and not root.right: 
            res.append(ls + str(root.val))
        if root.left: 
            self.dfs(root.left, ls+ str(root.val) +"->", res)
        if root.right:
            self.dfs(root.right,ls+ str(root.val) +"->", res)



############## dfs + stack####################
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        if not root: 
            return []
        res, stack = [], [(root, "")]
        
        while stack: 
            node, ls = stack.pop()
            if not node.left and not node.right:
                res.append(ls + str(node.val))
            if node.right: 
                stack.append((node.right, ls+str(node.val) + "->"))
            if node.left: 
                stack.append((node.left, ls +str(node.val) + "->"))
        return res

############### bfs + queue############################

    def binaryTreePaths2(self, root):
        if not root:
            return []
        res, queue = [], collections.deque([(root, "")])
        while queue:
            node, ls = queue.popleft()
            if not node.left and not node.right:
                res.append(ls+str(node.val))
            if node.left:
                queue.append((node.left, ls+str(node.val)+"->"))
            if node.right:
                queue.append((node.right, ls+str(node.val)+"->"))
        return res