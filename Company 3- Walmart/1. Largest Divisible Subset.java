//Problem: https://leetcode.com/problems/largest-divisible-subset/description/
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int dp[] = new int[n];
        int hash[] = new int[n];
        Arrays.fill(dp, 1);

        for(int i=0; i<n; i++) {
            hash[i] = i;
            for(int prev=0; prev < i; prev++) {
                if(nums[i] % nums[prev] == 0 && dp[i] < dp[prev] + 1) {
                    dp[i] = dp[prev] + 1;
                    hash[i] = prev; 
                }
            }
        }

        // Retriving the elements

        int idx = -1, ele = -1;
        for(int i=0; i<dp.length; i++) {
            if(dp[i] > ele) {
                ele = dp[i];
                idx = i;
            }
        }

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(nums[idx]);

        while(hash[idx] != idx) {
            idx = hash[idx];
            temp.add(nums[idx]);
        }

        Collections.reverse(temp);

        return temp;
    }
}
