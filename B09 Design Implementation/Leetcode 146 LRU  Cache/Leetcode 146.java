/*


*/ 

class LRUCache {
    private int capacity; 
    private final HashMap<Integer, Node> map; 
    private Node head; 
    private Node end; 
    
    public LRUCache(int capacity) {
        this.capacity = capacity; 
        map = new HashMap<>();
    }
    
    public int get(int key) {
        //not exist
        if(!map.containsKey(key)) return -1; 
        //key exist, then move it to the front
        Node n = map.get(key); 
        remove(n); 
        setHead(n); 
        return n.value; 
    }
    
    public void put(int key, int value) {       
       //key exits 
        if(map.containsKey(key)){           //(1, 1)-->(1,100)
            //update the value
            Node n = map.get(key); 
            n.value = value; 
            remove(n); 
            setHead(n);

            }
        
        //no key exists
        else{
            Node created = new Node(key, value);
            //reach the capacity, move the oldest item
            if(map.size()>= capacity){
            map.remove(end.key);
            remove(end); 
            setHead(created);
                
            }
            //insert the entry into list and update mapping
            else{
                setHead(created);
            }
            map.put(key, created);
        }
    }
    
    private void remove(Node n){
        if(n.prev != null){
            n.prev.next = n.next; 
        } else {
            head = n.next; 
        }
        
        if(n.next != null){
            n.next.prev = n.prev;
        } else{
            end = n.prev; 
        }
    }
    
    private void setHead(Node n){
        n.next = head; 
        n.prev = null; 
        if(head!=null) head.prev =n; 
        
        head = n; 
        
        if (end == null) end = head; 
    }
    
    //doubly Linked List
    class Node{
        int key; 
        int value; 
        Node prev; 
        Node next; 
        
        public Node(int key, int value){
            this.key = key; 
            this.value = value; 
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
