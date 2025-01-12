// Problem: https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        Integer indexes[] = new Integer[nums.length];
        // Sort the indexes...
        for(int i=0; i<nums.length; i++) {
            indexes[i] = i;
        }

        Arrays.sort(indexes, (a, b) -> nums[b] - nums[a]);

        // Get the k elements...
        int res[] = new int[k];
        for(int i=0; i<k; i++) {
            res[i] = indexes[i];
        }

        Arrays.sort(res);

        for(int i=0; i<res.length; i++) {
            res[i] = nums[res[i]];
        }

        return res;
    }
}
