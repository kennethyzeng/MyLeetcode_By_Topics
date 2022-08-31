###########Link source###############


###########Jave Version##############

import java.util.*;
public class MyClass {
    public static boolean  result = true;
    public static void main(String args[]) {

        TreeNode testCase1 = input3();
        System.out.println("The result for testcase 1 is " + isBalanced(testCase1));
        
        // result = true; 
        // TreeNode testCase2 = input2();
        // System.out.println("The result for testcase 2 is " + isBalanced(testCase2));
    }
    
    public static TreeNode input1(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2); 
        root.left.left = new TreeNode(3); 
        root.left.right = new TreeNode(3); 
        root.left.left.left = new TreeNode(4); 
        root.left.left.right = new TreeNode(6);  
        
        return root; 
    }
    
    public static TreeNode input3(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3); 
        root.left.left = new TreeNode(4); 
        root.left.right = new TreeNode(5); 
        root.left.left.left = new TreeNode(6); 
        root.left.left.right = new TreeNode(7);  
        
        return root; 
    }
    
    public static TreeNode input2(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20); 
        // root.left.left = new TreeNode(3); 
        // root.left.right = new TreeNode(3); 
        root.right.left = new TreeNode(15); 
        root.right.right = new TreeNode(7);  
        
        return root; 
    }
    
    public static boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result; 
    }
    
    private static int maxDepth(TreeNode root){
        if(root == null) return 0; 
        System.out.println("current root value is:  " + root.val);
        int l = maxDepth(root.left); 
        System.out.println("Display l after l is executed: " + l + " and Root is: " + root.val + "\n");
        
        int r = maxDepth(root.right); 
        System.out.println("dialay l after r is executed: " + l + " and Root is: " + root.val );
        System.out.println("Display r after r is executed: " + r+ " and Root is: " + root.val );
        System.out.println("Display result after r is executed:  " + result+ "\n");
        if(Math.abs(l-r) >1) {
            result = false;
            //System.out.println("Display current result status:  " + result+ "\n");  //should print result herer
            return 0; //exit recursion
            //System.out.println("check if exit");
        }
        return(1+ Math.max(l,r)); 
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



#############Python Version###########
