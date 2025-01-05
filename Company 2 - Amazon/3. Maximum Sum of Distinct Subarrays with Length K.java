// Problem: https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/
class Solution {
    public long maximumSubarraySum(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        long sum = 0;
        long maxSum = Long.MIN_VALUE;

        // first window
        while (r < k && r < arr.length) {
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
            sum += arr[r];
            r++;
        }

        // Check if the first window is valid
        if (map.size() == k) {
            maxSum = sum;
        }

        // Slide the window
        while (r < arr.length) {
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
            sum += arr[r];

            map.put(arr[l], map.get(arr[l]) - 1);
            if (map.get(arr[l]) == 0) map.remove(arr[l]);
            sum -= arr[l];
            l++;

            if (map.size() == k) maxSum = Math.max(maxSum, sum);
            r++;
        }

        return maxSum == Long.MIN_VALUE ? 0 : maxSum;
    }
}
