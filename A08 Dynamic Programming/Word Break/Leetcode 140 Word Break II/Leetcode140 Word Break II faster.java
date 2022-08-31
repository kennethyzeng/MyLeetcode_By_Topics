/*
Time Complexity:
Space Complexity:
DP + recurision
*/ 
class Solution {
    HashMap<String,List<String>> map = new HashMap<>();
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict);
    }
    
    private List<String>helper(String s, List<String>dict){
        if (map.containsKey(s)) return map.get(s);
        
        List<String>res = new ArrayList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word:dict) {
            // It returns true if word is a prefix of s.
            if (s.startsWith(word)) {
                List<String>recRes = helper(s.substring(word.length()), dict);
                StringBuilder sb = new StringBuilder();
                for (String temp:recRes) {
                    //just forming answer and adding to res list
                    res.add(sb.append(word).append(temp.isEmpty()?"" : " ").append(temp).toString());
                    
                    //Now clear sb
                    sb.setLength(0);
                }
            }
        }
        map.put(s, res);
        return res;
    }
}

/*
 * run time O(n^3)
 * space O(n^3)
 */