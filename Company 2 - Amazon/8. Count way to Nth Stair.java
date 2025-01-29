// https://leetcode.com/problems/find-number-of-ways-to-reach-the-k-th-stair/description/
class Solution {
    public int solve(int i, int jump, int back, int[][][] dp, int k) {
        if (i > k+1) 
            return 0;

        if (dp[i][jump][back] != -1) return dp[i][jump][back];
    
        int ans = (i == k) ? 1 : 0;
        if (back == 1 && i > 0) 
            ans += solve(i - 1, jump, 0, dp, k);

        ans += solve(i + (1 << jump), jump + 1, 1, dp, k);

        return dp[i][jump][back] = ans;
    }

    public int waysToReachStair(int k) {
        int maxI = k + 10; 
        int maxJump = 20;  

        int[][][] dp = new int[maxI][maxJump][2];
        
        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }

        return solve(1, 0, 1, dp, k);
    }
}
