// Problem: https://leetcode.com/problems/maximum-product-of-the-length-of-two-palindromic-subsequences/
class Solution {
    public boolean isPalindrome(StringBuilder s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public int solve(int idx, StringBuilder s1, StringBuilder s2, String s) {
        if (idx < 0) {
            if (isPalindrome(s1) && isPalindrome(s2)) 
                return s1.length() * s2.length();
            return 0;
        }

        // Opt 1: Add character to s1
        s1.append(s.charAt(idx));
        int opt1 = solve(idx - 1, s1, s2, s);
        s1.deleteCharAt(s1.length() - 1); 

        // Opt 2: Add character to s2
        s2.append(s.charAt(idx));
        int opt2 = solve(idx - 1, s1, s2, s);
        s2.deleteCharAt(s2.length() - 1);

        // Opt 3: Ignore the current char
        int opt3 = solve(idx - 1, s1, s2, s);

        return Math.max(opt1, Math.max(opt2, opt3));
    }

    public int maxProduct(String s) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        return solve(s.length() - 1, s1, s2, s);
    }
}
