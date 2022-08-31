//BFS with queue

class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length]; //default 0: not visited
       for (int i = 0; i < graph.length; i++){
           if (visited[i] != 0) {
               continue; 
           }
           Queue<Integer> queue = new LinkedList();
           queue.add(i);
           visited[i] = 1; //mark as red
           while (!queue.isEmpty()){
               int cur = queue.poll(); 
               int curLable = visited[cur];
               int neighborLable = curLable ==1? 2: 1; 
               for (int neighbor : graph[cur]){
                   if(visited[neighbor] == 0){
                       visited[neighbor] = neighborLable; 
                       queue.add(neighbor); 
                   }else if(visited[neighbor] != neighborLable){
                       return false;
                   }
               }
           }
       }
        return true;  
    }
}