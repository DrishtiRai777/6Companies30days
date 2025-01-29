// https://leetcode.com/problems/construct-the-longest-new-string/description/
class Solution {
    public int longestString(int x, int y, int z) {
        int length = z * 2;

        if (x == 0 && y == 0) return length;
        if (x == 0 || y == 0) return length + 2;
        if (x == y) return length + (x * 4);
        
        return length + (Math.min(x, y) * 4) + 2;
    }
}
