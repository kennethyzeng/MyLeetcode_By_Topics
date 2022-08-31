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
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0; 
        int[] maxPath = new int[]{Integer.MIN_VALUE};
        dfs(root, maxPath); 
        return maxPath[0];
    }
    
    private int dfs(TreeNode root, int[] maxPath){
        if(root == null) return 0;
        
        int left = Math.max(dfs(root.left, maxPath), 0);            //math.max: if the root.val is negative, it reset to 0; don't need to continue
        int right = Math.max(dfs(root.right, maxPath), 0); 
        maxPath[0] = Math.max(maxPath[0], root.val + left + right); //maxpath so far
        return Math.max(left, right) + root.val;           //return leg with max value
    }
    
}