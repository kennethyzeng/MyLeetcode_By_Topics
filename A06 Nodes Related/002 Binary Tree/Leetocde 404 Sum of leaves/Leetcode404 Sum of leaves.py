###########


#############
##DFS
class Solution:
    def sumOfLeftLeaves(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        # does this node have a left child which is a leaf?
        if root.left and not root.left.left and not root.left.right:
			# gotcha
            return root.left.val + self.sumOfLeftLeaves(root.right)

        # no it does not have a left child or it's not a leaf
        else:
			# bummer
            return self.sumOfLeftLeaves(root.left) + self.sumOfLeftLeaves(root.right)



#############BFS
class Solution:
    def sumOfLeftLeaves(self, root: TreeNode) -> int:
        if not root:
            return 0
        que = [root]
        res = 0
        while que:
            for _ in range(len(que)):
                node = que.pop(0)
                if node.left:  
                    que.append(node.left)
                    if not node.left.left and not node.left.right:
                        res += node.left.val
                if node.right:
                    que.append(node.right)
        return res