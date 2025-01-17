// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/
class Solution {
    public int[][] floydWarshall(int n, int[][] edges) {
        // Creating cost matrix
        int cost[][] = new int[n][n];
        for(int i=0; i<n; i++) {
            Arrays.fill(cost[i], (int)1e9);
            cost[i][i] = 0;
        }

        for(int i=0; i<n; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            cost[u][v] = wt;
            cost[v][u] = wt;
        }

        // Floyd Warshall
        for(int via=0; via<n; via++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    cost[i][j] = Math.min(cost[i][j], cost[i][via] + cost[via][j]);
                }
            }
        }

        return cost;
    }
    
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int cost[][] = floydWarshall(n, edges);
        int min = Integer.MAX_VALUE, node = -1;

        for(int i=0; i<n; i++) {
            int reachable = 0;
            for(int j=0; j<n; j++) {
                if(cost[i][j] <= distanceThreshold)
                    reachable++; 
            }

            if(reachable < min) min = reachable;
            if(reachable == min) node = i;
        }

        return node;
    }
}
