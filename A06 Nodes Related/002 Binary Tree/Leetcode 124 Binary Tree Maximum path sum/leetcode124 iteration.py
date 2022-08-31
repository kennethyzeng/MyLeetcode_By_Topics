from collections import defaultdict
class Solution(object):
    
    def maxPathSum(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        res = float('-inf')
        stack, last, d = [], None, defaultdict(int)
        while root or stack:
            while root:
                stack.append(root)
                root = root.left
            node = stack[-1]        
            if node.right and last != node.right:
                root = node.right
            else:
                # Consume the node
                node = stack.pop()
                last = node
                d[node] = max(max(d[node.left], d[node.right]) + node.val, 0)
                res = max(res, d[node.left] + d[node.right] + node.val)
                
        return res