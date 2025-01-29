// https://leetcode.com/problems/get-equal-substrings-within-budget/description/
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int start = 0, end = 0, costSum = 0;

        while (end < s.length()) {
            costSum += Math.abs(s.charAt(end) - t.charAt(end));
            end++;

            if (costSum > maxCost) {
                costSum -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }
        }

        return end - start;
    }
}
