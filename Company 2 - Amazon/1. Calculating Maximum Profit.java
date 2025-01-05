// Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
class Solution {
    public int solve(int n, int k, int prices[]) {
        int ahead[][] = new int[2][k+1];
        // Base Case
        for(int canBuy=0; canBuy<2; canBuy++) {
            for(int cap=0; cap<=k; cap++) 
                ahead[canBuy][cap] = 0;
        }

        for(int idx=n-1; idx>=0; idx--) {
            int curr[][] = new int[2][k+1];
            for(int canBuy=0; canBuy<2; canBuy++) {
                for(int cap=1; cap<=k; cap++) {
                    if (canBuy == 0) {
                        int moveOn = ahead[0][cap];
                        int buy = -prices[idx] + ahead[1][cap];
                        curr[canBuy][cap] = Math.max(moveOn, buy);
                    }
                    else {
                        int moveOn = ahead[1][cap];
                        int sell = prices[idx] + ahead[0][cap-1];
                        curr[canBuy][cap] = Math.max(moveOn, sell);
                    }
                }
            }

            ahead = curr;
        }

        return ahead[0][k];
    }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        return solve(n, k, prices);
    }
}
