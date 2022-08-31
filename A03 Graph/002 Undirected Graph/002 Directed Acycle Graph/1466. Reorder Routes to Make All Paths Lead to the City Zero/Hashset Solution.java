/*
Time Complexity:
Space Complexity:

This code cause time limit exceed in leetcode bauase on input have 5000 cities element 
75 out of 76 pass
*/ 


class Solution {
    public int minReorder(int n, int[][] connections) {
        Set<Integer> set = new HashSet<>(); 
        int res = 0; 
        set.add(0); 
        
        while(set.size() != n){
            for(int i = 0; i < connections.length; i++){
                if (set.contains(connections[i][1])){
                    set.add(connections[i][0]);
                }else if(set.contains(connections[i][0]) && !set.contains(connections[i][1])){
                    set.add(connections[i][1]);
                    res +=1;
                }
            }
        }
        return res; 
    }
}