###########Comments###############
Java Example:
Main are within class MyClss; other class are not within class Myclass
class TreeNode, and method isSymmetric and helper are all within class Method

How to Treat?
Need to initialization before use. Something like this 
TreeNode root = new TreeNode(1);
Method res = new Method();

Note: 
#1 Other classes are sharing same file with class Myclass, you don't need to put "public" to other class 
Just class "string" . Example 
Class Method

#2 if the classes in different file and are called by main function in different file, need to set classes in public and call and initialization by filename.classname
Public class Method{}

From filename import Method
Method example = new Method()

###########Jave Version##############

import java.util.*;
public class MyClass {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        System.out.println(root.val);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2); 
        root.left.left = new TreeNode(3); 
        root.left.right = new TreeNode(4); 
        root.right.left = new TreeNode(4); 
        root.right.right = new TreeNode(3);   //case 2: change the value to other valsue
        
        Method res = new Method(); 
        System.out.println(res.isSymmetric(root));
        //System.out.println("The result is " + isSymmetric(root));
        
    }
}
    
    // public static TreeNode
 class Method{ 
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
}
    
    //Definition of TreeNode
     class TreeNode {
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
