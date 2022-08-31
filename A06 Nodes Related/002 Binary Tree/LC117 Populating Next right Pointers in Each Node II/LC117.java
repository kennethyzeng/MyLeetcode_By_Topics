/*
Time Complexity:
Space Complexity:

*/ 

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node next = null;
        Node current = root;
        
        while(current.next != null && next == null) {
            next = current.next.left;
            if (next == null) {
                next = current.next.right;
            }
            current = current.next;
        }
        
        if (root.left != null) {
            root.left.next = root.right;
        }
        
        if (root.right != null) {
         root.right.next = next;   
        } else if (root.left != null) {
            root.left.next = next;
        }
        
        connect(root.right);
        connect(root.left);
        return root;
    }
}
