// https://leetcode.com/problems/find-the-distance-value-between-two-arrays/
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int cnt = 0;
        for(int i=0; i<arr1.length; i++) {
            boolean flag = true;
            for(int j=0; j<arr2.length; j++) {
                if(Math.abs(arr1[i] - arr2[j]) <= d) {
                    flag = false;
                    break;
                }
            }

            if(flag) cnt++;
        }

        return cnt;
    }
}
