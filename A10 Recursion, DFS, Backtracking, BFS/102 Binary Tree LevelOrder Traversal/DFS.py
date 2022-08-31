# DFS recursively
def levelOrder1(self, root):
    res = []
    self.dfs(root, 0, res)
    return res
    
def dfs(self, root, level, res):
    if not root:
        return 
    if len(res) < level+1:
        res.append([])
    res[level].append(root.val)
    self.dfs(root.left, level+1, res)
    self.dfs(root.right, level+1, res)