/*


*/ 


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
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        //corner case 
        if (node == null) return node; 
        return dfs(node);
    }
    
    private Node dfs(Node node){
        if(node == null) return node; 
        
        if (map.containsKey(node)){
            return map.get(node);
        }else{
            Node newNode = new Node(node.val); 
            map.put(node, newNode); 
            //newNode's neighbors
            List<Node> list = new ArrayList<>();
            for (Node nei: node.neighbors){
                list.add(dfs(nei));
            }
            newNode.neighbors = list; 
            return newNode;
        }
    }
}