/*
Time Complexity:  O(n)
Space Complexity:  O(1)

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
        if (root == null) return root;
        
        Node level_start = root; 
        //start from here
        while(level_start != null){
            Node cur = level_start;
            while(cur != null){
                if(cur.left != null){
                    cur.left.next = cur.right; 
                    if(cur.next != null){
                        cur.right.next = cur.next.left;     //cur.next is current root.next; it was node which connected to current root; 
                    }
                }
                cur = cur.next;
            }
         //end here=> process connection for the whole level
        level_start = level_start.left;
        }
       return root; 
        
    }
}