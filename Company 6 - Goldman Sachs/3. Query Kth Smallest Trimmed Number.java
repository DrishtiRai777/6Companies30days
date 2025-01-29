// https://leetcode.com/problems/query-kth-smallest-trimmed-number/
class Solution {
    public int helper(String[] nums, int k, int trim) {
        List<Pair<String, Integer>> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            String num = nums[i];
            String trimmed = num.substring(num.length() - trim); 
            list.add(new Pair(trimmed, i));
        }

        Collections.sort(list, (a, b) -> a.getKey().compareTo(b.getKey()));
        return list.get(k-1).getValue(); 
    }

    public int[] smallestTrimmedNumbers(String[] nums, int[][] q) {
        int[] res = new int[q.length];
        int idx = 0;
        
        for(int i = 0; i < q.length; i++) {
            int k = q[i][0];
            int trim = q[i][1];
            res[idx++] = helper(nums, k, trim); 
        }

        return res;
    }
}
