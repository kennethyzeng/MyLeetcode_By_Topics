
*****good
class Solution:
    def countNodes(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root is None:
            return 0
        l = self.leftHeight(root.left)
        r = self.leftHeight(root.right)
        if l == r:
            return self.countNodes(root.right) + (1<<l)
        return self.countNodes(root.left) + (1 << r)

    def leftHeight(self, node):
        height = 0
        while node is not None:
            height += 1
            node = node.left
        return height



########
def compute_depth(root):
    d = 0
    while root:
        root = root.left
        d += 1
    return d

class Solution:
    def countNodes(self, root: TreeNode) -> int:
        cnt = 0
        while root:
            ll = compute_depth(root.left)
            rl = compute_depth(root.right)
            if ll == rl:  # Left is perfect binary tree.
                cnt += 2**ll
                root = root.right
            else:  # Right is a perfect binary tree.
                cnt += 2**rl
                root = root.left
        return cnt