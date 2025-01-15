// Problem: https://leetcode.com/problems/battleships-in-a-board/
class Solution {
    public void dfs(int row, int col, int n, int m, char[][] board, boolean vis[][]) {
        vis[row][col] = true;

        int drow[] = {-1, 0, 1, 0};
        int dcol[] = {0, 1, 0, -1};

        for(int i=0; i<4; i++) {
            int newRow = row + drow[i];
            int newCol = col + dcol[i];

            if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && board[newRow][newCol] == 'X' &&vis[newRow][newCol] == false) 
                dfs(newRow, newCol, n, m, board, vis);
        }
    }

    public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean vis[][] = new boolean[n][m];
        int cnt = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == 'X' && vis[i][j] == false) {
                    dfs(i, j, n, m, board, vis);
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
