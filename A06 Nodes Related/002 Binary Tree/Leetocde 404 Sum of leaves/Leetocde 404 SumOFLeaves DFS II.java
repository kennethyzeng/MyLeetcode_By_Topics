/*
better to understand DFS: 
a) for dfs, it only add value when meet below condition for dfs
       if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;

b) it will do dfs for left first, then dfs for right leg
*/ 

public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        } else {
            sum += sumOfLeftLeaves(root.left);
        }
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }
}
