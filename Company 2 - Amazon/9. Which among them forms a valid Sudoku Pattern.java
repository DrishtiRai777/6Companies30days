// Problem: https://leetcode.com/problems/valid-sudoku/description/
class Solution {
    public boolean isValid(char[][] board, int row, int col, char ch) {
        // Check horizontal, vertical, and grid
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == ch)
                return false;

            if (board[row][i] == ch)
                return false;

            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == ch)
                return false;
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    char ch = board[i][j];
                    board[i][j] = '.'; 
                    if (!isValid(board, i, j, ch))
                        return false;
                    board[i][j] = ch;  
                }
            }
        }
        return true;
    }
}
