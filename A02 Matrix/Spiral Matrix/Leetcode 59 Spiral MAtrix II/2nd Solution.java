/*
Time Complexity:
Space Complexity:
TC: O(N^2) | SC: O(1)
*/ 

class Solution {
    public int[][] generateMatrix(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[][] result = new int[n][n];
        if (n == 0) {
            return result;
        }

        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int row = 0;
        int col = 0;
        int dirIdx = 0;
        int num = 1;

        while (num <= n * n) {
            result[row][col] = num++;
            row += dirs[dirIdx][0];
            col += dirs[dirIdx][1];

            if (row < 0 || row >= n || col < 0 || col >= n || result[row][col] != 0) {
                // Moving back from invalid position
                row -= dirs[dirIdx][0];
                col -= dirs[dirIdx][1];
                // Going to next dir
                dirIdx = (dirIdx + 1) % 4;
                // Updating row and col to valid next position
                row += dirs[dirIdx][0];
                col += dirs[dirIdx][1];
            }
        }

        return result;
    }
}