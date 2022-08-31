################
Height of node The height of a node is the number of edges on the longest downward path between that node and a leaf.
dfs function calculates the height of the node, i.e, the longest downward path between the node and a leaf.
For a node, the length of longest path going through the node is the sum of left child's height plus right child's height.
For each node in the binary tree, we calculate the length of the longest length going through the node, the maximum length is the diameter of the binary tree according to the definition --The diameter of a binary tree is the length of the longest path between any two nodes in a tree.


###############

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        self.diameter = 0
        self.dfs(root)
        return self.diameter
    
    def dfs(self, node):
        # base case:
        if node == None:
            return 0
		# recursive cases
        left_height = self.dfs(node.left)
        right_height = self.dfs(node.right)
        self.diameter = max(self.diameter,left_height + right_height )
        return max(left_height,right_height) + 1