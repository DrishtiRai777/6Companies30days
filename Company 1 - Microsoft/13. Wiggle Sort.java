// https://leetcode.com/problems/wiggle-sort-ii/
class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int median = nums[n / 2]; 

        int i = 0, j = 0, k = n - 1;
        
        while (j <= k) {
            int mappedJ = getVirtualIdx(j, n);
            if (nums[mappedJ] > median) {
                swap(nums, getVirtualIdx(i++, n), mappedJ);
                j++;
            } else if (nums[mappedJ] < median) 
                swap(nums, mappedJ, getVirtualIdx(k--, n));
            else 
                j++;
        }
    }

    private int getVirtualIdx(int i, int n) {
        return (1 + 2 * i) % (n | 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
