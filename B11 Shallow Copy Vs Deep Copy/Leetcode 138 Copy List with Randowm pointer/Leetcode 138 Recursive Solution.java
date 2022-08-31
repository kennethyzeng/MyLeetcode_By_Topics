/*
Time O(n)
Space O(n)

*/ 


/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node, Node> map = new HashMap<Node, Node>();
    public Node copyRandomList(Node head) {         //Node here
        if (head == null) {
            return null;
        }
        if (map.containsKey(head)) {                //case: if the node is visited or copied already
            return map.get(head);
        }
        
        Node clone = new Node(head.val);
        map.put(head, clone);
        clone.next = copyRandomList(head.next);
        clone.random = copyRandomList(head.random);
        
        return clone;
    }
}