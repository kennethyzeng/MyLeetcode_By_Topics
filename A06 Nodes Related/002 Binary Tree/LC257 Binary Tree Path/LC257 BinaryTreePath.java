##########Fast solution#####
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
    List<String> ans;
    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<>();
        solve(root, new StringBuilder());
        return ans;
    }
    
    public void solve(TreeNode root, StringBuilder res){
        if(root == null)
            return;
        
        int len = res.length();
        res.append(root.val);
        if(root.left == null && root.right == null){
            ans.add(res.toString());
        }
        else{
            res.append("->");
            if(root.left != null)
                solve(root.left, res);
            if(root.right != null)
                solve(root.right, res);
        }
        res.setLength(len);
    }
}


####### Recursively#######
public class Solution {

##########################
//Recursion
public List<String> binaryTreePaths(TreeNode root) {
    List<String> sList=new LinkedList<String>();
    //String s=new String();
    if (root==null) return sList;
    if (root.left==null && root.right==null) {
        sList.add(Integer.toString(root.val));
        return sList;
    }
    
    for (String s: binaryTreePaths(root.left)) {
        sList.add(Integer.toString(root.val)+"->"+s);
    }
    for (String s: binaryTreePaths(root.right)) {
        sList.add(Integer.toString(root.val)+"->"+s);
    }
    return sList;
}
#############################


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        if not root:
            return []
        res = []
        self.dfs (root, "", res)
        return res 
    
    def dfs(self, root, ls, res):
        if not root.left and not root.right: 
            res.append(ls + str(root.val))
        if root.left: 
            self.dfs(root.left, ls+ str(root.val) +"->", res)
        if root.right:
            self.dfs(root.right,ls+ str(root.val) +"->", res)



############## dfs + stack####################
public class Solution {
//DFS - Stack
public List<String> binaryTreePaths(TreeNode root) {
    List<String> list=new ArrayList<String>();
    Stack<TreeNode> sNode=new Stack<TreeNode>();
    Stack<String> sStr=new Stack<String>();
    
    if(root==null) return list;
    sNode.push(root);
    sStr.push("");
    while(!sNode.isEmpty()) {
        TreeNode curNode=sNode.pop();
        String curStr=sStr.pop();
        
        if(curNode.left==null && curNode.right==null) list.add(curStr+curNode.val);
        if(curNode.left!=null) {
            sNode.push(curNode.left);
            sStr.push(curStr+curNode.val+"->");
        }
        if(curNode.right!=null) {
            sNode.push(curNode.right);
            sStr.push(curStr+curNode.val+"->");
        }
    }
    return list;
}

############### bfs + queue############################

    public class Solution {
//BFS - Queue
public List<String> binaryTreePaths(TreeNode root) {
    List<String> list=new ArrayList<String>();
    Queue<TreeNode> qNode=new LinkedList<TreeNode>();
    Queue<String> qStr=new LinkedList<String>();
    
    if (root==null) return list;
    qNode.add(root);
    qStr.add("");
    while(!qNode.isEmpty()) {
        TreeNode curNode=qNode.remove();
        String curStr=qStr.remove();
        
        if (curNode.left==null && curNode.right==null) list.add(curStr+curNode.val);
        if (curNode.left!=null) {
            qNode.add(curNode.left);
            qStr.add(curStr+curNode.val+"->");
        }
        if (curNode.right!=null) {
            qNode.add(curNode.right);
            qStr.add(curStr+curNode.val+"->");
        }
    }
    return list;
}