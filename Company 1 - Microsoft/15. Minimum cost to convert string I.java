// Problem: https://leetcode.com/problems/minimum-cost-to-convert-string-i/description/
class Solution {
    public void floydWarshall(int[][] mat) {
        int n = mat.length;
         // Initial Configuration
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == -1) 
                    mat[i][j] = (int) 1e9;
                if (i == j) 
                    mat[i][j] = 0;
            }
        }

        // Floyd-Warshall Algo
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = Math.min(mat[i][j], mat[i][via] + mat[via][j]);
                }
            }
        }
    }

    public long minimumCost(String source, String target, char[] ori, char[] changed, int[] cost) {
        if (source.length() != target.length()) 
            return -1;

        // Create cost matrix for Floyd-Warshall
        int[][] mat = new int[26][26];
        for (int[] row : mat)
            Arrays.fill(row, -1);

        for (int i = 0; i < ori.length; i++) {
            int u = ori[i] - 'a';
            int v = changed[i] - 'a';
            mat[u][v] = (mat[u][v] == -1) ? cost[i] : Math.min(mat[u][v], cost[i]);
        }

        floydWarshall(mat);

        // Calc. cost
        long totalCost = 0;
        for (int i = 0; i < source.length(); i++) {
            int u = source.charAt(i) - 'a';
            int v = target.charAt(i) - 'a';
            if (mat[u][v] == (int) 1e9) 
                return -1;
            totalCost += mat[u][v];
        }

        return totalCost;
    }
}
