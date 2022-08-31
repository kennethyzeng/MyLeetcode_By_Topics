###########Link source###############
https://www.geeksforgeeks.org/write-c-code-to-determine-if-two-trees-are-identical/

###########Jave Version##############
/* Driver program to test identicalTrees() function */
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
  
        tree.root1 = new Node(1);
        tree.root1.left = new Node(2);
        tree.root1.right = new Node(3);
        tree.root1.left.left = new Node(4);
        tree.root1.left.right = new Node(5);
  
        tree.root2 = new Node(1);
        tree.root2.left = new Node(2);
        tree.root2.right = new Node(3);
        tree.root2.left.left = new Node(4);
        tree.root2.left.right = new Node(5);
  
        if (tree.identicalTrees(tree.root1, tree.root2))
            System.out.println("Both trees are identical");
        else
            System.out.println("Trees are not identical");
  
    }
}


#############Python Version###########
# Driver program to test identicalTress function
root1 = Node(1)
root2 = Node(1)
root1.left = Node(2)
root1.right = Node(3)
root1.left.left = Node(4)
root1.left.right = Node(5)
 
root2.left = Node(2)
root2.right = Node(3)
root2.left.left = Node(4)
root2.left.right = Node(5)
 
if identicalTrees(root1, root2):
    print "Both trees are identical"
else:
    print "Trees are not identical"
 
# This code is contributed by Nikhil Kumar Singh(nickzuck_007)