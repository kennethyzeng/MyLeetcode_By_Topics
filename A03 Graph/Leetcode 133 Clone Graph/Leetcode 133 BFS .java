/*
Runtime: 56 ms, faster than 10.11% of Java online submissions for Clone Graph.
Memory Usage: 40 MB, less than 30.02% of Java online submissions for Clone Graph.

*/ 


/*
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    public Node cloneGraph(Node node) {
        //corner case 
        if (node == null) return null; 
        Map<Node, Node> map = new HashMap<>();
        Node newNode = new Node(node.val, new ArrayList<>()); 
        map.put(node, newNode);
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            for (Node nei: cur.neighbors){
                if(!map.containsKey(nei)){
                    map.put(nei, new Node(nei.val, new ArrayList<>()));
                    queue.add(nei);
                }
                map.get(cur).neighbors.add(map.get(nei));
            }
        }
        return newNode;
    }
    
}