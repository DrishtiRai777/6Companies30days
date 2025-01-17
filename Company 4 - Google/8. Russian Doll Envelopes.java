// https://leetcode.com/problems/russian-doll-envelopes/
class Solution {
    public int maxEnvelopes(int[][] env) {
        // Sort in inc order of width and in case of tie, sort by height in desc order
        Arrays.sort(env, (a, b) -> {
            if (a[0] == b[0]) 
                return b[1] - a[1];
            else 
                return a[0] - b[0];
        });

        int[] heights = new int[env.length];
        for (int i = 0; i < env.length; i++) {
            heights[i] = env[i][1];
        }

        return lengthOfLIS(heights);
    }

    private int lengthOfLIS(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        int len = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > temp.get(temp.size() - 1)) {
                temp.add(nums[i]);
                len++;
            } else {
                int lowerBound = Collections.binarySearch(temp, nums[i]);
                if (lowerBound < 0) 
                    lowerBound = -lowerBound - 1;
                temp.set(lowerBound, nums[i]);
            }
        }

        return len;
    }
}

