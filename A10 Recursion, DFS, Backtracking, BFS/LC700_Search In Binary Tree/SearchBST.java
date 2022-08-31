/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode curr = root; 
        while (curr != null){
            if(curr.val == val){
                return curr; 
            }
            else if(curr.val > val){
                curr = curr.left; 
            }
            else
                curr = curr.right;    
        }
        return curr;
        
    }
}

##########Recursion#######
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return root;
        if (root.val > val)
            root = searchBST(root.left, val);
        else if (root.val < val)
            root = searchBST(root.right, val);
        
        return root;   
        
    }
}


########################
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) return null;
        
        if(root.val==val) return root;
        
        return searchBST((val>root.val)? root.right : root.left, val);
        
    }