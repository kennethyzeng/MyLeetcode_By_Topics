## RC ##
## APPROACH : SEGMENT TREE ##
# Tree Construction : O( N )
# Query in Range : O( log N )
# Updating an element : O( log N )
class SegmentNode:
    def __init__(self, start, end, val = 0, left = None, right = None):
        self.start = start
        self.end = end
        self.val = val
        self.left = None
        self.right = None

class SegmentTree:
    def __init__(self, nums):
        self.root = self.build(nums, 0, len(nums)-1)
        
    def build(self, nums, lo, hi):
        if lo > hi:         # might look like not required, but is required when array of length 0 is given as input
            return None
        
        if lo == hi: 
            return SegmentNode(lo, hi, nums[lo])
        
        node = SegmentNode(lo, hi)
        mid = lo + (hi - lo)//2
        
        node.left = self.build(nums, lo, mid)
        node.right = self.build(nums, mid+1, hi)
        
        node.val = node.left.val + node.right.val
        
        return node
    
    # return range sum between i to j
    def query(self, lo, hi):
        def helper(node, lo, hi):
            if node.start == lo and node.end == hi:
                return node.val
            
            mid = node.start + (node.end - node.start)//2
            
            if hi <= mid:
                return helper(node.left, lo, hi)        # entire range falls left side
            elif lo >= mid + 1:
                return helper(node.right, lo, hi)       # entire range falls right side
            
            return helper(node.left, lo, mid) + helper(node.right, mid+1, hi)   # range falls either side
        
        return helper(self.root, lo, hi)
    
    # replaces nums[idx] with val
    def update(self, idx, val):
        def helper(node, idx, val):
            if node.start == node.end:
                node.val = val
                return val
            
            mid = node.start + (node.end - node.start)// 2
            
            if idx <= mid:
                helper(node.left, idx, val)
            else:
                helper(node.right, idx, val)
            
            node.val = node.left.val + node.right.val
            return node.val
        
        return helper(self.root, idx, val)
    
    # updates all the numbers from [lo, hi] by adding delta value
    def updateRange(self, lo, hi, delta):
        def helper(node, lo, hi, delta):

            if lo == hi == node.start == node.end:
                node.val += delta
                return node.val
            
            mid = node.start + (node.end - node.start)//2
            if hi <= mid:
                node.val = helper(node.left, lo, hi, delta) + node.right.val        # as right side value doesn't change, we add directly
                return node.val
            elif lo >= mid + 1:
                node.val = helper(node.right, lo, hi, delta) + node.left.val        # as left side value doesn't change, we add directly
                return node.val
            
            node.val = helper(node.left, lo, mid, delta) + helper(node.right, mid + 1, hi, delta )
            return node.val
            
        helper(self.root, lo, hi, delta)
    
class NumArray:

    def __init__(self, nums: List[int]):
        self.segment_tree = SegmentTree(nums)

    def update(self, i: int, val: int) -> None:
        self.segment_tree.update(i, val)
        # prev = self.segment_tree.query(i, i)           # you can check verify the functionality of updateRange with these 2 steps
        # self.segment_tree.updateRange(i, i, val - prev)

    def sumRange(self, i: int, j: int) -> int:
        return self.segment_tree.query(i,j)