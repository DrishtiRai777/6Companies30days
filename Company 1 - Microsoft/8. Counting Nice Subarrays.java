// Problem: https://leetcode.com/problems/count-number-of-nice-subarrays/
class Solution {
    public int solve(int nums[], int goal) {
        if(goal < 0) return 0;
        int l = 0, r = 0, sum = 0, cnt = 0;
        while(r < nums.length) {
            sum += (nums[r] % 2);
            while(sum > goal) {
                sum -= (nums[l] % 2);
                l++;
            }

            cnt += (r-l+1);
            r++;
        }

        return cnt;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        // solve() - finds: No of subarray with sum <= goal
        int x = solve(nums, k);
        int y = solve(nums, k-1);

        return x - y;
    }
}
