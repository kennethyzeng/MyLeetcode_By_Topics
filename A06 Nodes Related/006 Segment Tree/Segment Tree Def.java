/*


*/ 


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

    ##########################Build the tree###########
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
    