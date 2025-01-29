// https://leetcode.com/problems/k-divisible-elements-subarrays/description/
class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        HashSet<String> set = new HashSet<>();

        for(int i=0; i<nums.length; i++) {
            StringBuilder sb = new StringBuilder();
            int cnt = 0;
            for(int j=i; j<nums.length; j++) {
                sb.append(nums[j]).append(",");
                if(nums[j] % p == 0) {
                    cnt++;
                }
                if(cnt <= k) set.add(sb.toString());
                else break;
            }
        }

        return set.size();
    }
}
