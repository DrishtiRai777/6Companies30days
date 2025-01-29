// https://leetcode.com/problems/number-of-ways-to-reach-a-position-after-exactly-k-steps/description/
class Solution {
    public int helper(int currPos, int endPos, int K, int dp[][]) {
        int MOD = (int)1e9 + 7;
        // Base Case
        if(K == 0) {
            if(currPos == endPos) return 1;
            return 0;
        }

        if(dp[currPos + 1000][K] != -1) return dp[currPos + 1000][K];

        // Options
        int left = helper(currPos - 1, endPos, K - 1, dp);
        int right = helper(currPos + 1, endPos, K - 1, dp);

        return dp[currPos + 1000][K] = (left + right) % MOD;
    }

    public int numberOfWays(int startPos, int endPos, int k) {
        int dp[][] = new int[3000][k+1];
        for(int row[]: dp) 
            Arrays.fill(row, -1);
        return helper(startPos, endPos, k, dp);
    }
}
