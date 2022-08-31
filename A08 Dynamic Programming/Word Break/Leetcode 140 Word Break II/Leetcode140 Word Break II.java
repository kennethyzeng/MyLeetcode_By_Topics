/*
Time Complexity:
Space Complexity:
DP + recurision
*/ 

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return backtrack(s, wordDict, new HashMap<String, List<String>>());
    }
    
    //backtrack returns an array including all substring derived from s
    private List<String> backtrack(String s, List<String> wordDict, Map<String, List<String>> mem){
        if (mem.containsKey(s)) return mem.get(s); 
        List<String> result = new ArrayList<String>();
        for (String word : wordDict){
            if(s.startsWith(word)){
                String next = s.substring(word.length()); 
                if(next.length() == 0) result.add(word);
                else for(String sub: backtrack(next, wordDict, mem)) result.add(word + " " + sub);
            }
        }
        mem.put(s, result); 
        return result; 
    }
}
