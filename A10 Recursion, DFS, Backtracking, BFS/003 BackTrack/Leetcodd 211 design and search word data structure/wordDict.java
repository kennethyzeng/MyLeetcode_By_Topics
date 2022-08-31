class WordDictionary {

    /** Initialize your data structure here. */
    private class TrieNode{    //TrieNode definition
        public TrieNode[]children;
        public boolean isWord; 
        public String word; 
        public TrieNode(){
            children = new TrieNode[26];
            isWord = false; 
            word = "";
        }
    }
    
    private TrieNode root; 
    
    public WordDictionary() {
       root = new TrieNode(); 
    }
    
    public void addWord(String word) {
        TrieNode node = root; 
        for(int i = 0; i < word.length(); i ++){
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index]; 
        }
        node.isWord = true; 
        node.word = word; 
    }
    
    /** returns if the word is in the data structure. A word could contain the dot character */
    public boolean search(String word) {
        return find(word, root, 0);
    }
    
    public boolean find(String word, TrieNode node, int index){
        if (node == null) return false; 
        if (index == word.length()) return node.isWord; 
        
        if (word.charAt(index) == '.'){
            for (TrieNode temp: node.children){
                if(find(word, temp, index +1)){
                    return true;
                }
            }
        } else {
            int tempIndex = word.charAt(index) - 'a';
            TrieNode temp = node.children[tempIndex];
            
            return find(word, temp, index +1);
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */