// https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] arr) {
        this.k = k;
        pq = new PriorityQueue<>();
        for (int num : arr) {
            pq.add(num);

            if (pq.size() > k) pq.poll();
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if (pq.size() > k) pq.poll();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
