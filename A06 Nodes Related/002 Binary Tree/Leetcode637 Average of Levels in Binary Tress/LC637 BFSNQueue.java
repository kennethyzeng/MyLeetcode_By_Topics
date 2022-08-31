/*

Complexity: time complexity is O(n), we need to traverse all our tree. Space complexity is O(w + h): there will be at most O(w) elements in our queue each moment of time, where w is width of tree; also final answer will have size O(h).
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>(); 
        Queue<TreeNode> queue = new LinkedList<>(); 
        
        if(root == null) return res; 
        
        queue.add(root); 
        while(!queue.isEmpty()){
            int count = queue.size(); 
            double sum = 0.0; 
            for(int i = 0; i < count; i ++){
                TreeNode cur = queue.poll(); 
                sum += cur.val; 
                if(cur.left != null) queue.offer(cur.left); 
                if (cur.right != null) queue.offer(cur.right);
            }
            res.add(sum/count);
        }
        return res; 
    }
}