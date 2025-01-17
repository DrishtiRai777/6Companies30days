// https://leetcode.com/problems/maximum-product-after-k-increments/description/
class Solution {
    public int maximumProduct(int[] arr, int k) {
        int MOD = (int)(1e9 + 7);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<arr.length; i++) 
            pq.add(arr[i]);

        while(k-- > 0) {
            int ele = pq.remove();
            pq.add(ele + 1);
        }

        long prod = 1;
        while(!pq.isEmpty()) {
            prod = (prod * pq.poll()) % MOD;
        }

        return (int)prod;
    }
}
