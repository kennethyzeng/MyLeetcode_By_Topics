//https://www.youtube.com/watch?v=rSDG7mlk5iQss

/*
class TrieNode{
    char Val; 
    TrieNode[] children; 
    String word; 

    public TrieNode(char x){
        children = new TrieNode[26];		//size is 26 for a-z 
        word = null; 
    }
}
*/

private void buildTrie(TireNode root, String[] words){
    for(String s: words){				//one of those words
        TrieNode cur = root; 
        for (char c: s.toCharArray()){			//character of that particular word
            if(cur.children[c - 'a'] == null){		//if currently index is null, create one ==> have such character
                cur.children[c - 'a'] = new TrieNode(c);
            }
            cur = cur.children[c -'a'];			//otherwise, move to next position
        }
        cur.word = s; 					// at the end of path, let word = that particular word
    }
}

