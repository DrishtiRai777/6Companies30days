// https://leetcode.com/problems/count-the-number-of-square-free-subsets/description/
class Solution {
    private static final int MOD = 1_000_000_007;
    private int gcd(int a, int b) {
        while (b != 0) {
            a = b;
            b = a % b;
        }
        return a;
    }

    private long solve(int mask, List<Integer> nums, long[] dp, Map<Integer, Integer> freq) {
        if (dp[mask] != -1) return dp[mask];

        long ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            if ((mask & (1 << i)) == 0) {
                boolean isValid = true;
                for (int j = 0; j < nums.size(); j++) {
                    if ((mask & (1 << j)) != 0 && gcd(nums.get(i), nums.get(j)) != 1) {
                        isValid = false;
                        break;
                    }
                }
                if(isValid) 
                  ans = (ans + ((solve(mask | (1 << i), nums, dp, freq) + 1) * freq.get(nums.get(i))) % MOD) % MOD;
            }
        }
        return dp[mask] = ans;
    }

    public int squareFreeSubsets(int[] nums) {
        Map<Integer, Integer> notSquareFree = new HashMap<>();
        for (int i = 2; i <= 5; i++) {
          for (int j = i * i; j <= 30; j += i * i) 
            notSquareFree.put(j, 1);
        }

        List<Integer> squareFreeNums = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        int ones = 0;

        for (int num : nums) {
            if (num == 1) ones++;
            else if (!notSquareFree.containsKey(num)) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
                if (freq.get(num) == 1) squareFreeNums.add(num);
            }
        }

        long[] dp = new long[1 << squareFreeNums.size()];
        Arrays.fill(dp, -1);
        long result = solve(0, squareFreeNums, dp, freq);

        for (int i = 0; i < ones; i++) result = (result * 2 + 1) % MOD;

        return (int) result;
    }
}
