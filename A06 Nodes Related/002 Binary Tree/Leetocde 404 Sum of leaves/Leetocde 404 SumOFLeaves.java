/*
Time Complexity: As we are traversing each node once, the time complexity will be O(N), where N is number of nodes.
Space Complexity: It takes stack space, as we are doing recursion. So space complexity is O(H), where H is the height of tree.

Better to understand DFS: 
a) itself is trick for root.val  ==> it won't have value if it is right left since helper(root.right, false)
b) it will check all root, and only add left leg value
return helper(root.left, true) + helper(root.right, false);
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
    public int sumOfLeftLeaves(TreeNode root) {
       return helper(root, false); 
    }
    
    private int helper(TreeNode root, boolean itself){
        if (root == null) return 0; 
        
        if (root.left == null && root.right == null && itself){
            return root.val; 
        }
        
        return helper(root.left, true) + helper(root.right, false);
    }
}
