###########
Time Complexity:
Space Complexity:


#############
def hasPathSum1(self, root, sum):
    res = []
    self.dfs(root, sum, res)
    return any(res)
    
def dfs(self, root, target, res):
    if root:
        if not root.left and not root.right and root.val == target:
            res.append(True)
        if root.left:
            self.dfs(root.left, target-root.val, res)
        if root.right:
            self.dfs(root.right, target-root.val, res)

# DFS with stack
def hasPathSum2(self, root, sum):
    if not root:
        return False
    stack = [(root, root.val)]
    while stack:
        curr, val = stack.pop()
        if not curr.left and not curr.right and val == sum:
            return True
        if curr.right:
            stack.append((curr.right, val+curr.right.val))
        if curr.left:
            stack.append((curr.left, val+curr.left.val))
    return False