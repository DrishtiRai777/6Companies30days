// https://leetcode.com/problems/minimize-the-maximum-of-two-arrays/description/
class Solution {
    public long gcd(long a, long b) {
        while (a > 0 && b > 0) {
            if (a > b) a = a % b;
            else b = b % a;
        }

        if (a == 0) return b;
        return a;
    }

    public long lcm(long a, long b) {
        long temp = (a / gcd(a, b)) * b;
        return temp > Integer.MAX_VALUE ? Integer.MAX_VALUE : temp;
    }

    public boolean isValid(long D1, long D2, int ucnt1, int ucnt2, long X, long lcm) {
        long divByD1 = X / D1;
        long divByD2 = X / D2;
        long elements1 = X - divByD1;
        long elements2 = X - divByD2;
        long overlapping = X / lcm;

        if (ucnt1 <= elements1 && ucnt2 <= elements2 && ucnt1 + ucnt2 <= X - overlapping)
            return true;
        return false;
    }

    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long low = 2, high = Integer.MAX_VALUE;
        long LCM = lcm(divisor1, divisor2);
        int ans = 0;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (isValid(divisor1, divisor2, uniqueCnt1, uniqueCnt2, mid, LCM)) {
                ans = (int) mid;
                high = mid - 1;
            } else low = mid + 1;
        }

        return ans;
    }
}
