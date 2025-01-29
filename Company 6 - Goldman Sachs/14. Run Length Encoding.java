// https://www.geeksforgeeks.org/problems/run-length-encoding/1
class Solution {
    public static String encode(String s) {
        // Base Case
        if(s.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        char ch = s.charAt(0);
        int cnt = 1;
        for(int i=1; i<s.length(); i++) {
            char currChar = s.charAt(i);
            if(currChar == ch) 
                cnt++;
            else {
                // Append the ch...
                sb.append(ch);
                sb.append(cnt);
                // reset
                ch = currChar;
                cnt = 1;
            }
        }
        
        sb.append(ch);
        sb.append(cnt);
        
        return sb.toString();
    }
}
