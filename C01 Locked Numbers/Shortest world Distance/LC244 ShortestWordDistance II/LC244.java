/*
Time Complexity: O(n)
Space complexity: O(n)

Hashmap
*/ 

class WordDistance{
    Map<String, List<Integer>> map = new HashMap<>();

    publis WordDistance(String[] words){
        //Step1: store all the word and its index locations into hashmap; index are sorted in order
        for(int i = 0; i < worlds.length; i++){
            if (map.containsKey(words[i]){
                map.get(words[i]).add(i);
            } else{
                List<Integer> List = new ArrayList<>();
                list.add(i); 
                map.put(word[i], list);
            }
        }
    }
    //comparing and find the shortest distance between two words
    public int shortest(String word1, String word2){
        List<Integer> l1 = map.get(word1); 
        List<Integer> l2 = map.get(word2); 
        int i = 0, j = 0; 
        int result = Integer.MAX_Value; 
        while (i <l1.size() && j < l2.size()){
            if (l1.get(i) < l2.get(j){
                result = Math.min(result, l2.get(j) - l1.get(i));
                i ++;
            } else {
                result = Math.min(result, l1.get(i)-l2.get(j));
                j++;
            }
        }
        return result; 
    }

}