/*
Time Complexity:  O(n)
Space Complexity: 0(height)

*/ 

/**
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
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>(); 
        helper(root, targetSum, new ArrayList<>());
        return res; 
    }
    
    public void helper(TreeNode root, int targetSum, List<Integer> temp){
        if (root == null) 
            return; 
        
        if(root.left == null && root.right == null && root.val == targetSum) {
            temp.add(root.val);        
            res.add(new ArrayList<>(temp));
            temp.remove(temp.size() -1);
            return; 
        }           
        
        temp.add(root.val);
        helper(root.left, targetSum -root.val, temp); 
        helper(root.right, targetSum -root.val, temp); 
        temp.remove(temp.size()-1);
    
    }
}