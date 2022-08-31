 
 /*

  terative solution in Java, O(h) time and O(1) space
If the node to be deleted has
1. Only left child: Overwrite it with left child
2. Only right child: Overwrite it with right child
3. Both left and right child
a. find the min node in the right child
b. append the left child of the node to be deleted to this min node's left child
*/
 
 
 public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root;
        TreeNode pre = null;
        
        while(cur != null && cur.val != key) {
            pre = cur;
            if (key < cur.val) 
                cur = cur.left;
            else if (key > cur.val)
                cur = cur.right;
        }
        if (pre == null) //deleting root      ###in the case, only one node and node.value == key s
            return deleteThisNode(cur);
        
        if (pre.left == cur)   //deleting pre's left node
            pre.left = deleteThisNode(cur);
        
        else  //deleting pre's right node
            pre.right = deleteThisNode(cur);
        
        return root;
    }
    
    //Finding the min node, ie, the leftmost node
    private TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    
    private TreeNode deleteThisNode(TreeNode root) {
        if (root == null)
            return null;
        
        //since left child is null, overwrite it with right child
        if (root.left == null) 
            return root.right;
        
        //since right child is null, overwrite it with left child
        if (root.right == null) 
            return root.left;
        
        /*
        if both the left and right child exists, then 
            1. find the min node in the right child         //TreeNode next = findMin(root.right);
            2. append the left child of the node to 
               be deleted to this min node's left child    //next.left = root.left;
        */
        TreeNode next = findMin(root.right); //find the min value in the right child
        next.left = root.left;//so that the left child of the node to be deleted is not lost
        return root.right;
    }    
}```