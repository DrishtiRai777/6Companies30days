// https://leetcode.com/problems/map-of-highest-peak/description/
class Tuple {
    int first; // row
    int second; // col
    int third; // dist

    Tuple(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int[][] highestPeak(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<Tuple> q = new LinkedList<>();
        int dist[][] = new int[n][m];
        boolean vis[][] = new boolean[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1){
                    q.offer(new Tuple(i, j, 0)); 
                    vis[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()) {
            Tuple tup = q.poll();
            int row = tup.first;
            int col = tup.second;
            int distance = tup.third;

            int drow[] = {-1, 0, 1, 0};
            int dcol[] = {0, 1, 0, -1};

            for(int i=0; i<4; i++) {
                int newRow = row + drow[i];
                int newCol = col + dcol[i];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 0 && vis[newRow][newCol] == false) {
                    q.add(new Tuple(newRow, newCol, distance + 1));
                    dist[newRow][newCol] = distance + 1;
                    vis[newRow][newCol] = true;
                }
            }
        }

        return dist;
    }
}
