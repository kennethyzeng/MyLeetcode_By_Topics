/*
BFS JAVA

*/ 


class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>(); 
        if (n == 1){
            result.add(0); 
            return result;
        }
        
        //Step 1: 
        int[] degree = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>(); 
        for (int i = 0; i < n; i++)
            map.put(i, new ArrayList<>());    //create empty Hashmap for edges
        for(int [] pair: edges){            //due to undirected graph. add both node
            map.get(pair[0]).add(pair[1]);   //map.get(i) i is key==> return value 
            map.get(pair[1]).add(pair[0]);
            degree[pair[0]] ++; 
            degree[pair[1]] ++;
        }
        
        //Step 2: 
        Queue<Integer> queue = new LinkedList<>(); 
        for(int i = 0; i < n; i ++){
            if(degree[i] ==1) queue.add(i);
        }
        
        //Step 3: 
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>(); 
            int size = queue.size(); 
            for(int i = 0; i < size; i++){
                int cur = queue.poll(); 
                list.add(cur); 
                for(int nei : map.get(cur)){
                    degree[nei] --; 
                    if (degree[nei] == 1) queue.add(nei);
                }
            }
            result = list; 
        }
        return result; 
    }
}