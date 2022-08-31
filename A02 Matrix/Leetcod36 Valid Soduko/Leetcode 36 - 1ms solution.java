/*
Hashset

*/ 


class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[board.length];
        int[] cols = new int[board.length];
        int[] boxes = new int[board.length];

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                int val = Character.getNumericValue(board[r][c]);

                if ((rows[r] & (1 << (val - 1))) > 0) {
                    return false;
                }
                rows[r] = rows[r] | (1 << (val - 1));

                if ((cols[c] & (1 << (val - 1))) > 0) {
                    return false;
                }
                cols[c] = cols[c] | (1 << (val - 1));

                int boxIndex = ((r / 3) * 3) + c / 3;
                if ((boxes[boxIndex] & (1 << (val - 1))) > 0) {
                    return false;
                }
                boxes[boxIndex] = boxes[boxIndex] | (1 << (val - 1));

            }
        }

        return true;
    }
}