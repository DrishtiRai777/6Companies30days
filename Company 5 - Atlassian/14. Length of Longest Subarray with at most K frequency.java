// https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/description/ 
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int maxLen = 0;
        int l = 0, r = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while(r < nums.length) {
            int ele = nums[r];
            // Map increment and check
            map.put(ele, map.getOrDefault(ele, 0) + 1);
            if(map.get(ele) > k) {
                // reduce the window size
                while(l < nums.length && nums[l] != ele) {
                    map.put(nums[l], map.get(nums[l]) - 1);
                    if(map.get(nums[l]) == 0) map.remove(nums[l]);
                    l++;
                }
                
                // update the map and window size
                l++;
                map.put(ele, map.get(ele) - 1);
                if(map.get(ele) == 0) map.remove(ele);
            }
            else 
                maxLen = Math.max(maxLen, r-l+1);

            r++;
        }

        return maxLen;
    }
}
