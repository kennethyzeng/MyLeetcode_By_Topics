Idea
Do a DFS over a tree and save the sum and the number of nodes at every level.
Then iterate over the levels and find the average for each.

Complexity
Time: O(N), where N is the number of nodes in a tree
Memory: O(L), where L is the number of levels

################################### Method 1
def averageOfLevels(self, root: TreeNode) -> List[float]:
	lvlcnt = defaultdict(int)
	lvlsum = defaultdict(int)

	def dfs(node=root, level=0):
		if not node: return
		lvlcnt[level] += 1
		lvlsum[level] += node.val
		dfs(node.left, level+1)
		dfs(node.right, level+1)
		
	dfs()
	return [lvlsum[i] / lvlcnt[i] for i in range(len(lvlcnt))]
    
##########################method 2
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def averageOfLevels(self, root: TreeNode) -> List[float]:
        #using dfs
        def preorder(node,depth,sum_count):
            if node == None:
                return 
            if depth>=len(sum_count):
                sum_count.append([0,0])
            sum_count[depth][0]+=node.val
            sum_count[depth][1]+=1
            preorder(node.left,depth+1,sum_count)
            preorder(node.right,depth+1,sum_count)
        if root == None:
            return []
        sum_count=[]
        ans=[]
        preorder(root,0,sum_count)
        for s in sum_count:
            ans.append(s[0]/s[1])
        return ans