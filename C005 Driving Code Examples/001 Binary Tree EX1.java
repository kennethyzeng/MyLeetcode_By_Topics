###########Comments###############
Java Example:
Main, class TreeNode, and method isSymmetric and helper are all within class My class


###########Jave Version##############

import java.util.*;
public class MyClass {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2); 
        root.left.left = new TreeNode(3); 
        root.left.right = new TreeNode(4); 
        root.right.left = new TreeNode(4); 
        root.right.right = new TreeNode(3);   //case 2: change the value to other valsue
        
        System.out.println("The result is " + isSymmetric(root));
        
    }
    
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }
    
    private static boolean helper(TreeNode left, TreeNode right){
        if (left == null && right == null) return true; 
        if (left == null || right== null) return false; 
        
        if (left.val != right.val) return false; 
        
        return helper(left.right, right.left) && helper(left.left, right.right);  
    }
    
    //Definition of TreeNode
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
}

