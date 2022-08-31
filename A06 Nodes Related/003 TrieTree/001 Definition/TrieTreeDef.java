class TrieNode{
    char Val; 
    TrieNode[] children; 
    String word; 

    public TrieNode(char x){
        children = new TrieNode[26]; 
        word = null; 
    }
}