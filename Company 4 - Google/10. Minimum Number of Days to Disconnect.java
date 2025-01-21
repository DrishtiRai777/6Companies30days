// https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island/description/
class Solution {
    public void dfs(int row, int col, int grid[][], boolean vis[][]) {
        int n = grid.length, m = grid[0].length;
        vis[row][col] = true;

        int drow[] = {-1, 0, 1, 0};
        int dcol[] = {0, 1, 0, -1};

        for(int i=0; i<4; i++) {
            int newRow = row + drow[i];
            int newCol = col + dcol[i];

            if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1 && vis[newRow][newCol] == false) {
                dfs(newRow, newCol, grid, vis);
            }
        }
    }

    public boolean isDisconn(int grid[][]) {
        int n = grid.length, m = grid[0].length;
        boolean vis[][] = new boolean[n][m];

        int cnt = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1 && vis[i][j] == false) {
                    cnt++;
                    if(cnt > 1) return true;
                    dfs(i, j, grid, vis);
                }
            }
        }

        return cnt == 0; // no land
    }

    public int minDays(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        
        if(isDisconn(grid)) return 0;

        // Convert the 2nd block from land -> water
        int land = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1) {
                    grid[i][j] = 0; // convert
                    
                    if(isDisconn(grid)) return 1;

                    grid[i][j] = 1; // revert
                }
            }
        }

        return 2;
    }
}
