// https://leetcode.com/problems/random-flip-matrix/
class Solution {
    HashMap<Integer, Integer> map;
    int m, n, total; // m = rows, n = cols
    Random rand;

    public Solution(int m, int n) {
        map = new HashMap<>();
        rand = new Random();
        this.m = m;
        this.n = n;
        reset();
    }
    
    public int[] flip() {
        // Get a random idx and decrease the total
        int i = rand.nextInt(total --);
        int x = map.getOrDefault(i, i); 
        map.put(i, map.getOrDefault(total, total));
        map.put(total, x);

        return new int[] {x/n, x%n};
    }
    
    public void reset() {
        total = m*n;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */
