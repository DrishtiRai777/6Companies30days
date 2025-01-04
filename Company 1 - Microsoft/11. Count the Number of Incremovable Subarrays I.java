// Problem: https://leetcode.com/problems/count-the-number-of-incremovable-subarrays-i/
class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int cnt = 0; 

        for(int i=0; i<nums.length; i++) {
            for(int j=i; j<nums.length; j++) {
                int lastEle = -1;
                boolean flag = true;
                for(int k=0; k<nums.length; k++) {
                    if(k >= i && k <= j) continue;
                    if(lastEle >= nums[k]) {
                        flag = false;
                        break;
                    }
                    lastEle = nums[k];
                }
                if(flag == true) cnt++;
            }
        }

        return cnt;
    }
}
