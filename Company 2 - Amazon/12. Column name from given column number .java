// Problem: https://leetcode.com/problems/excel-sheet-column-title/description/
class Solution {
    public String convertToTitle(int colNum) {
        StringBuilder sb = new StringBuilder("");
        while(colNum > 0) {
            int offset = (colNum - 1) % 26;
            sb.append((char) ('A' + offset));
            colNum = (colNum - 1) / 26;
        }

        return sb.reverse().toString();
    }
}
