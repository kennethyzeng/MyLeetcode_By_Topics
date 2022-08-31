/*
T   O(n)
S   O(h)

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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1]; 
        dfs(root, diameter); 
        return diameter[0]; 
    }
    
    private int dfs(TreeNode root, int[] diameter){
        if (root == null) return 0; 
    
        int left = dfs(root.left, diameter); 
        int right = dfs(root.right, diameter); 
    
        diameter[0] = Math.max(diameter[0], left + right ); 
        return Math.max(left, right) +1; 
    }
}


##################similar
public class Solution {
    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
    
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        max = Math.max(max, left + right);
        
        return Math.max(left, right) + 1;
    }
}