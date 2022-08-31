/*
Recursive solution
Time Complexity:  O(n)
Space Complexity:  O(height)

*/ 

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
    public void flatten(TreeNode root) {
        if (root == null) return; 
        
        TreeNode tempLeft = root.left; 
        TreeNode tempRight = root.right; 
        
        root.left = null; 
        
        flatten(tempLeft);
        flatten(tempRight);
        
        root.right = tempLeft; 
        TreeNode current = root; 
        while(current.right != null) current = current.right; 
        current.right = tempRight;
    }
}
