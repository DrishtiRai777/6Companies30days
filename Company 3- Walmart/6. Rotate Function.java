// https://leetcode.com/problems/rotate-function/description/
class Solution {
    public int maxRotateFunction(int[] nums) {
        if(nums.length == 0) return 0;

        int sum = 0, prevRotSum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            prevRotSum += (i * nums[i]);
        }

        int max = prevRotSum;

        for(int i=1; i<nums.length; i++) {
            prevRotSum = prevRotSum - sum + nums[i-1]*nums.length;
            max = Math.max(prevRotSum, max);
        }

        return max;
    }
}
