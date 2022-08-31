/*
    Time complexity : O(MXN)
    Space complexity : O(MXN) in worse case

    First, check the four border of the matrix. If there is a element is
    'O', alter it and all its neighbor 'O' elements to 'N'.

    Then ,alter all the 'O' to 'X'

    At last,alter all the 'N' to 'O'

    example: 

    X X X X           X X X X             X X X X
    X X O X  ->       X X O X    ->       X X X X
    X O X X           X N X X             X O X X
    X O X X           X N X X             X O X X

*/ 

class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return; 
        
        int m = board.length, n =board[0].length; 
        for(int i = 0; i < m; i ++){
            if (board[i][0] == 'O') dfs(i, 0, board); 
            if(board[i][n-1] == 'O') dfs(i, n-1, board); 
        }
        
        for(int j = 0; j < n; j++){
            if(board[0][j] == 'O') dfs(0, j, board); 
            if (board[m-1][j] == 'O') dfs(m-1, j, board); 
        }
        
        for(int i = 0; i < m ; i++){
            for (int j = 0; j < n; j ++){
                if (board[i][j] == 'O') board[i][j] = 'X'; 
                if(board[i][j]=='A') board[i][j] = 'O';
            }
        }
    }
        
    private void dfs(int i, int j, char[][]board){
        //corner case 
        if(i < 0 || i > board.length-1 || j < 0 || j > board[0].length-1) return; 
        if (board[i][j] != 'O') return; 
        board[i][j]  = 'A'; 
        dfs(i+1, j, board); 
        dfs(i-1, j, board); 
        dfs(i, j+1, board); 
        dfs(i, j-1, board); 
    }
        
    
}
