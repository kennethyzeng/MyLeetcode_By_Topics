class Trie {
   Trie[] trie;
   boolean endOfString; 
      public Trie()
      {
         trie=new Trie[26] ;
         this.endOfString=false;  
      }
      public void insert(String word)
      {
        Trie t=this;
        for(char c:word.toCharArray() )  
        {
           if(t.trie[c-'a']==null )  
              t.trie[c-'a']=new Trie();
           t=t.trie[c-'a']; 
        }
         t.endOfString=true;  
      }
     public boolean search(String word)
     {
       Trie t=this;
       for(char c:word.toCharArray() ) 
       {
          if(t.trie[c-'a']==null  )  return false;
          t=t.trie[c-'a'];  
       }
        return t.endOfString;  
     }
    
    public boolean startsWith(String prefix)
    {s
      Trie t=this;
      for(char c:prefix.toCharArray() )  
      {
         if(t.trie[c-'a']==null )  return false;
         t=t.trie[c-'a'];  
      }
      return true;   
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */




