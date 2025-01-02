// Problem: https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        int oper = 0;
        
        for (int num : nums) {
            oper += Math.abs(num - median);
        }
        
        return oper;
    }
}
