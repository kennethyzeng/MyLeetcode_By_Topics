/*
Runtime: 95 ms, faster than 63.59% of Java online submissions for Range Sum Query - Mutable.
Memory Usage: 70.4 MB, less than 77.98% of Java online submissions for Range Sum Query - Mutable.

*/ 

class NumArray {
    class SegmentTreeNode{
        int val; 
        int start, end; 
        SegmentTreeNode left; 
        SegmentTreeNode right; 
        
        public SegmentTreeNode(int start, int end){
            this.start = start; 
            this.end = end; 
            this.val = 0;
            this.left = null; 
            this.right = null; 
        }
    }
   /*
    Time Complixity: O(n)
    build SegmentTree
    */ 

    private SegmentTreeNode root; 
    public NumArray(int[] nums) {
        this.root = buildTree(nums, 0, nums.length - 1);
    }
    
    private SegmentTreeNode buildTree(int[] nums, int start, int end){
        if (start > end) return null;
        SegmentTreeNode node = new SegmentTreeNode(start, end); 
        if (start == end) {
            node.val = nums[start];
        }else{
            int mid = start + (end - start) / 2; 
            node.left = buildTree(nums, start, mid); 
            node.right = buildTree(nums, mid + 1, end); 
            node.val = node.left.val + node.right.val; 
        }
        return node; 
        
    }
    
       /*
    Time Complixity: O(log n)
    update()
    */ 
    public void update(int index, int val) {
        update(this.root, index, val);         
    }
    
    void update(SegmentTreeNode root, int i, int val) {
        if (root.start == root.end){
            root.val = val; 
            return;
        }
        int middle = root.start + (root.end -root.start)/2; 
        if (i <= middle){
            update(root.left, i, val); 
        }else{
            update(root.right, i, val); 
        }
        root.val = root.left.val + root.right.val;
    }
    /*
    Time Complixity: O(log n)
    sumRange()
    */ 
    
    public int sumRange(int left, int right) {
        return sumRange(this.root, left, right); 
    }
    
    public int sumRange(SegmentTreeNode root, int start, int end){
        if (root.end == end && root.start == start) return root.val; 
        int mid = root.start + (root.end - root.start)/2; 
        if (end <= mid){
            return sumRange(root.left, start, end); 
            
        }else if (start >= mid +1){
            return sumRange(root.right, start, end); 
        }else{
            return sumRange(root.right, mid + 1, end) + sumRange(root.left, start, mid); 
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
