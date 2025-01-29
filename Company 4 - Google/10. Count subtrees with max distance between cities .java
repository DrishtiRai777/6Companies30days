https://leetcode.com/problems/count-subtrees-with-max-distance-between-cities/description/
class Solution {
    public int[][] floydWarshal(int n, int[][] edges) {
        // Initial Configuration
        int dist[][] = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                dist[i][j] = (int)1e9;
                if(i == j) dist[i][j] = 0;
            }
        }

        for(int[] edge: edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            dist[u][v] = 1;
            dist[v][u] = 1;
        }

        // Floyd Warshall
        for(int via = 0; via < n; via++ ) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                }
            }
        }
        return dist;
    }

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        int dist[][] = floydWarshal(n, edges);
        int[] ans = new int[n-1];

        for(int state = 0; state < (1 << n); state++) { // 000... to 111...
            int d = maxDist(state, dist, n);
            if(d > 0) 
                ans[d-1]++;
        }

        return ans;
    }

    public int maxDist(int state, int dist[][], int n) {
        int cntEdge = 0, cntCity = 0, maxDist = 0;

        for(int i=0; i<n; i++) {
            if(((state >> i) & 1) == 0) continue; // 0 means city is not in our subset
            cntCity++; // +1 if that city is in the subset

            // Finding a pair with the cities that are present
            for(int j = i+1; j<n; j++) {
                if(((state >> j) & 1) == 0) continue; // abset
                if(dist[i][j] == 1) cntEdge++;
                maxDist = Math.max(maxDist, dist[i][j]);
            }
        }
        if(cntEdge != cntCity - 1) return 0; // invalid 
        return maxDist;
    }
}
