// https://leetcode.com/problems/find-consecutive-integers-from-a-data-stream/description/
class DataStream {
    int value;
    int k; // window size
    Deque<Integer> dq;
    int diffNum = 0;

    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
        dq = new LinkedList<>();
    }
    
    public boolean consec(int num) {
        // Add 
        if(dq.size() == k) {
            int popNum = dq.pollFirst();
            if(popNum != value) diffNum--;
        }
        dq.offerLast(num);
        if(num != value) diffNum++;

        // Return true or false
        if(dq.size() == k && diffNum == 0) return true;
        return false;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */
