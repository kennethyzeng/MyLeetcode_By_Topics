/*


*/ 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);      //recruisive
        return sb.toString();
    }
    private void buildString(TreeNode root, StringBuilder sb){
        //base case
        if(root == null){
            sb.append("#").append(",");
        }else{
            sb.append(root.val).append(",");
            buildString(root.left, sb); 
            buildString(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null) return null; 
        String[] strArr = data.split(","); 
        Queue<String> queue = new LinkedList<>();
        Collections.addAll(queue, strArr);
        return buildTree(queue);
    }
    
    private TreeNode buildTree(Queue<String> queue){
        if (queue.isEmpty()) return null; 
        String s = queue.poll(); 
        if (s.equals("#")) return null; 
        //to match serialized pre-order traversal
        TreeNode root = new TreeNode(Integer.valueOf(s));     //also okay with Integer.parseInt(s)
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root; 
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
