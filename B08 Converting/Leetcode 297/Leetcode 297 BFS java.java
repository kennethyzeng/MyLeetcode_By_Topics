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
        if (root==null) return "";
        Queue<TreeNode> qu=new LinkedList<>();
        StringBuilder sb=new StringBuilder();
        qu.offer(root);
        sb.append(String.valueOf(root.val));
        sb.append(' ');
        while (!qu.isEmpty()) {
            TreeNode x=qu.poll();
            if (x.left==null) sb.append("null ");
            else {
                qu.offer(x.left);
                sb.append(String.valueOf(x.left.val));
                sb.append(' ');
            }
            if (x.right==null) sb.append("null ");
            else {
                qu.offer(x.right);
                sb.append(String.valueOf(x.right.val));
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length()==0) return null;
        String[] node=data.split(" ");
        Queue<TreeNode> qu=new LinkedList<>();
        TreeNode root=new TreeNode(Integer.valueOf(node[0]));
        qu.offer(root);
        int i=1;
        while (!qu.isEmpty()) {
            Queue<TreeNode> nextQu=new LinkedList<>();
            while (!qu.isEmpty()) {
                TreeNode x=qu.poll();
                if (node[i].equals("null")) x.left=null;
                else {
                    x.left=new TreeNode(Integer.valueOf(node[i]));
                    nextQu.offer(x.left);
                }
                i++;
                if (node[i].equals("null")) x.right=null;
                else {
                    x.right=new TreeNode(Integer.valueOf(node[i]));
                    nextQu.offer(x.right);
                }
                i++;
            }
            qu=nextQu;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
