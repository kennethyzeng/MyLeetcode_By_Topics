/*
Time : O  (MxN)
Space: Space: O(\min{(M, N)}). In the worst case where the grid is filled with lands, the size of queue can be O(\min{(M, N)}) due to queue
*/ 
class Solution {
   
    public int numIslands(char[][] grid) {  
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int m = grid.length; 
        int n = grid[0].length; 
        int number_islands = 0; 
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j]=='1'&& !visited[i][j]){
                     
                    visited[i][j] = true; 
                    queue.offer(new int[] {i, j});
                    bfs(grid, queue, visited);
                    number_islands ++;
                } 
        
            }
        }
        return number_islands;    
    }
    
    private void bfs(char[][] grid, Queue<int[]> queue, boolean[][] visited){
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1, 0}};     //4 directions
        
        while(!queue.isEmpty()){
            int[]curr = queue.poll();
        
        
            //move to next location
            for(int[] dir: dirs){
                int x = curr[0] + dir[0];            
                int y = curr[1] + dir[1]; 

                if(x < 0 || x>=grid.length || y < 0 || y >= grid[0].length || visited[x][y] || grid[x][y] == '0')
                    continue; 

                visited[x][y] = true; 
                queue.offer(new int[]{x, y});
            }
        }
    }
}