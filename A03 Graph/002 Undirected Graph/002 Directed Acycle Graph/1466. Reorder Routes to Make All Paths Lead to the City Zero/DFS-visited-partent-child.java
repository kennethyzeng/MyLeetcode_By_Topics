/*
Time: O(n). We visit each node once.
Memory: O(n). We store n nodes in the adjacency list, with n - 1 edges in total.

if (!visited[Math.abs(child)])
                reOrderCount += dfs(adj, visited, Math.abs(child)) + (child > 0 ? 1:0);
*/ 

class Solution {
    
    // converting outgoing edges to incoming edges
    
    int count = 0;
    public void dfs(int src ,ArrayList<ArrayList<Integer>> graph,boolean[] vis){
        
        vis[src] = true;
        
        for(int nbr : graph.get(src)){
            if(!vis[Math.abs(nbr)]){
                // if the node is from par to child we have to reverse it 
                if(nbr > 0){
                    count+=1;
                }
                dfs(Math.abs(nbr),graph,vis);
            }
        }
    }
    
    public int minReorder(int n, int[][] connections) {
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] c : connections){
            graph.get(c[0]).add(c[1]);    // parent to child        
            graph.get(c[1]).add(-c[0]);   // child to parent

        }
        
        boolean[] vis = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,graph,vis);
            }
        }
        
        return count;
    }
}