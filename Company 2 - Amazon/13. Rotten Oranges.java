// Problem: https://leetcode.com/problems/rotting-oranges/description/
class Tuple {
    int first; // row
    int second; // col
    int third; // time

    Tuple(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<Tuple> q = new LinkedList<>();
        boolean vis[][] = new boolean[n][m];

        int freshOrg = 0;

        // Counting fresh org. and putting rotten ones in the queue...
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 2){
                    q.offer(new Tuple(i, j, 0));
                    vis[i][j] = true;
                }
                else if (grid[i][j] == 1) freshOrg++;
                else continue; 
            }
        }


        // starting the official BFS...
        int rottenTime = 0;
        int cnt = 0; // fresh org that are rotten
        int drow[] = {0, -1, 0, 1};
        int dcol[] = {-1, 0, 1, 0};

        while(!q.isEmpty()) {
            Tuple tup = q.poll();
            int row = tup.first;
            int col = tup.second;
            int time = tup.third;

            rottenTime = Math.max(time, rottenTime);

            // Visiting Neighbours
            for(int i=0; i<4; i++) {
                int newRow = row + drow[i];
                int newCol = col + dcol[i];

                // Within boundaries + fresh + not visited
                if(newRow >= 0 && newRow < n && newCol >=0 && newCol < m && grid[newRow][newCol] == 1 && vis[newRow][newCol] == false) {
                    vis[newRow][newCol] = true;
                    q.add(new Tuple(newRow, newCol, time+1));
                    cnt++;
                }
            }
        }


        if(freshOrg != cnt) return -1;
        return rottenTime;

    }
}
