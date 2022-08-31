/*
MEthod 1: Backtracking
Method 2: BFS with queue

two clolor problems
*/ 

//Time O(n+m)      Space O(n)
class Solution {
    public boolean isBipartite(int[][] graph) {
        //lable 1: red
        //lable 2: green
        int[] color  = new int[graph.length];
        for(int i = 0 ; i< graph.length; i++){
            if(color[i] != 0) continue;
            color[i] = 1;
            if(!backtrack(graph, color, i)) return false;
        }
        
        return true;
    }
    
    private boolean backtrack(int[][] graph, int[] color, int i){
        for(int j = 0; j< graph[i].length ; j++){
            int next = graph[i][j];
            if(color[next] != 0){
                if(color[next] != -color[i] ) return false;
            }else{
                color[next] = -color[i];
                 if(!backtrack(graph, color, next)) return false;
            }
        }
        
        return true;
    }
}
