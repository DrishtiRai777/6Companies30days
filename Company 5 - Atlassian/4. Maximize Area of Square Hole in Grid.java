// https://leetcode.com/problems/maximize-area-of-square-hole-in-grid/
class Solution {
    public int areaLibrated(int arr[]) {
        int maxCnt = 0;
        int last = arr[0];
        int cnt = 0;
        for(int i=1; i<arr.length; i++) {
            if(arr[i] == last + 1)
                cnt++;
            else {
                maxCnt = Math.max(maxCnt, cnt);
                cnt = 0;
            }
            last = arr[i];
        }
        maxCnt = Math.max(maxCnt, cnt);
        return maxCnt + 2;
    }
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        // Area librated - cnt of consecutive + 2;
        int l = Math.min(areaLibrated(hBars), areaLibrated(vBars));
        return l*l;
        
    }
}
