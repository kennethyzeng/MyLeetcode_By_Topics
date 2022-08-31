/*
Time: O(N)
Extra Space (without counting output as space): O(logN)


I think the time is O(n), since T(n) = 2T(n/2) + O(1).
The space is O(logn) since there are at most logn recursion stacks in the meantime.
Correct me if I am wrong.
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length -1); 
    }
    
    private TreeNode helper(int[] nums, int start, int end){
        if (start > end) return null; 
        
        int mid = (start + end) /2; 
        TreeNode root = new TreeNode (nums[mid]);
        
        root.left = helper(nums, start, mid-1); 
        root.right = helper(nums, mid +1, end); 
        return root;
    }
}