class TrieNode{
    
    TrieNode[] children = new TrieNode[26]; ; 
    String word = null; 

}


class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>(); 
        if (board == null || board.length == 0) return res; 
        TrieNode root = new TrieNode();
        buildTrie(root, words); 		//build trieNode for each words
        for (int i = 0; i < board.length; i++){
            for (int j =0; j < board[0].length; j++){
                char c = board[i][j]; 
                if (root.children[c - 'a']!= null){	//if the 1st char match	
                    dfs(board, i , j, root, res);
                }
            } 
        }
        return res;
    }
    
    private void dfs(char[][] board, int i, int j, TrieNode cur, List<String> res){
        if(i < 0 || i >= board.length || j<0 || j>= board[0].length) return; 	//base condition 1
        
        char c = board[i][j];			//base condition 2 & 3
        if (c == '*') return; 			//already check
        if (cur.children[c - 'a'] == null) return;  //not such path
        
        cur= cur.children[c - 'a'];		//base condition 4:  
        if(cur.word != null){			//find a word
            res.add(cur.word);
            cur.word = null;			//since the wold is found, no need it anymore
        }
        
        board[i][j] ='*'; 			//mask
        dfs(board, i +1, j, cur, res);
        dfs(board, i -1, j, cur, res);
        dfs(board, i, j +1, cur, res);
        dfs(board, i, j - 1, cur, res);
        board[i][j] = c; 			//unmack. 
    }
    
//build each word in String[] words in trienode, and mark it; when the path reach that mark, we know it it void
    private void buildTrie(TrieNode root, String[] words){
        for(String s: words){
            TrieNode cur = root; 
            for (char c: s.toCharArray()){
                if(cur.children[c - 'a'] == null){		//if that particular index is null, create one
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c -'a'];			//move to next spot
            }
            cur.word = s; 
        }
    }
}