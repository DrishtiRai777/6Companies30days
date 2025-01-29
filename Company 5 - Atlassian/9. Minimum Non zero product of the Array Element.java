// https://leetcode.com/problems/minimum-non-zero-product-of-the-array-elements/description/
class Solution {
    static long MOD = 1000000007;
    public long helper(long N, long k) {
        if(k == 0) return 1;
        if(k == 1) return N%MOD;
        if(k%2 == 0) {
             long temp = helper(N, k/2);
            return (temp * temp)%MOD;
        }
        else {
             long temp = helper(N,k/2);
            temp = (temp*temp)%MOD;
            return (temp*(N%MOD))%MOD;
        }
    }
    public int minNonZeroProduct(int p) {
        long val = (long)Math.pow(2, p); // last digit
        val--; 
        long k = val/2; // == 1
        long N = val - 1;
        long ans = helper(N, k);

        return (int)(ans*((val) % MOD) % MOD);
    }
}
