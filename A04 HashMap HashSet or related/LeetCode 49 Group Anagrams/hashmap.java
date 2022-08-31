    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) return result;
        
        Map<String, List<String>> map = new HashMap<>();
        
        for(int i = 0; i < strs.length; i++) {   //for (String str: strs)
            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String hashKey = String.valueOf(charArr);  //valueof instead of toString 
         
            if(!map.containsKey(hashKey)){
                map.put(hashKey, new ArrayList<>());
            }
            map.get(hashKey).add(strs[i]);
        }


##########

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }