// https://leetcode.com/problems/find-in-mountain-array/ 
class Solution {
    public int findInMountainArray(int X, MountainArray arr) {
        int n = arr.length();
        int low = 0, high = n-1, peak = 0;
        // Get the peak
        while(low < high) {
            int mid = (low + high)/2;
            if(arr.get(mid) < arr.get(mid+1)) low = peak = mid+1;
            else high = mid;
        }

        // Find target in left
        low = 0; high = peak;
        while(low <= high) {
            int mid = (low + high)/2;
            if(arr.get(mid) == X) return mid;
            else if(arr.get(mid) < X) low = mid+1;
            else high = mid-1;
        }

        // Find target in right
        low = peak; high = n-1;
        while(low <= high) {
            int mid = (low + high)/2;
            if(arr.get(mid) == X) return mid;
            else if(arr.get(mid) > X) low = mid+1;
            else high = mid-1;
        }

        return -1;
    }
}
