class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int INF = (int) 1e6; 
        int[][] dist = new int[n][n]; 
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for (int[] edge : edges) {
            int v1 = edge[0], v2 = edge[1], w = edge[2];
            dist[v1][v2] = dist[v2][v1] = w;
        }
        
       
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
        
        int minReachable = n, ans = 0;
        for (int i = 0; i < n; i++) {
            int reachable = 0;
            for (int j = 0; j < n; j++)
                if (dist[i][j] <= distanceThreshold)
                    reachable++;
            if (reachable <= minReachable) {
                minReachable = reachable;
                ans = i;
            }
        }
        return ans;
    }
}
