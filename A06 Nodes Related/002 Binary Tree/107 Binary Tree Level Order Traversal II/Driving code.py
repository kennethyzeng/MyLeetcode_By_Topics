###########Link source###############


###########Jave Version##############


import java.util.*;
public class MyClass {
    public static boolean  result = true;
    public static void main(String args[]) {

        TreeNode testCase1 = input2();
        System.out.println("The result for testcase 1 is " + levelOrderBottom(testCase1));
        
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
    
       public static List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> res = new LinkedList<List<Integer>>();
            levelMaker(res, root, 0);
            return res;
        }
        
        public static void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
            if(root == null) return;
            System.out.println("root value is: " + root.val + "\n");
            if(level >= list.size()) {
                System.out.println("level and list.size inside if statement  " + level + "  " + list.size());
                list.add(0, new LinkedList<Integer>());
                System.out.println("list insdde if statenebt:   "+ list + "\n");
            }
            levelMaker(list, root.left, level+1);
            System.out.println("root value and #level after root.left  " + root.val + "  " + level);
            levelMaker(list, root.right, level+1);
            System.out.println("root value and #level after root.right  " + root.val + "  " + level);
            list.get(list.size()-level-1).add(root.val);
            System.out.println("Last line for root.val, leve, and list.size:  " + root.val + "  " + level + "  " + list.size());
            System.out.println(list + "\n");
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
