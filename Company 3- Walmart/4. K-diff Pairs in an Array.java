// Problem: https://leetcode.com/problems/k-diff-pairs-in-an-array/description/
class Solution {
    public int findPairs(int[] nums, int k) {
        if(k < 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        int cnt = 0;
        for(int i: nums) {
            if(map.containsKey(i)) {
                if(k == 0 && map.get(i) == 1) cnt++;
                map.put(i, map.get(i) + 1);
            }
            else {
                if(map.containsKey(i-k)) cnt++;
                if(map.containsKey(i+k)) cnt++;
                map.put(i, 1);
            }
        }

        return cnt;
    }
}
