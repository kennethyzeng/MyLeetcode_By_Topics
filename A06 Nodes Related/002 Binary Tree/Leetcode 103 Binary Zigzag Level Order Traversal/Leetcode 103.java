/*


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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        //corner case
        if (root == null) return res; 
        
        Queue<TreeNode> queue = new LinkedList<>();  
        queue.add(root);
        int level = 0;          //addon modification base on level order traversal
        while(!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.remove();
                tmp.add(cur.val);
                if (cur.left != null){
                    queue.add(cur.left); 
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }
            }
            if (level % 2 ==1) {         //addon modification base on level order traversal
                Collections.reverse(tmp);
            }
            res.add(tmp);
            level ++;       //addon modification base on level order traversal
        }
        return res; 
    }
}
