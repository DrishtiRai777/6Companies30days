// Problem: https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/description/
class Solution {
    TreeMap<Integer, Integer> map = new TreeMap<>(); 
    int totWt = 0; 
    int[][] rects; 

    public Solution(int[][] rects) {
        this.rects = rects;

        // Calc. weighted probabilities
        for (int i = 0; i < rects.length; i++) {
            int[] rect = rects[i];
            int x1 = rect[0], y1 = rect[1];
            int x2 = rect[2], y2 = rect[3];

            // Area = no. of int points
            int area = (x2 - x1 + 1) * (y2 - y1 + 1);

            totWt += area;
            map.put(totWt, i);
        }
    }
    
    public int[] pick() {
        int target = new Random().nextInt(totWt) + 1;

        // Get the corresponding rec. from the map
        int rectIdx = map.ceilingEntry(target).getValue();
        int[] rect = rects[rectIdx];
        int x1 = rect[0], y1 = rect[1];
        int x2 = rect[2], y2 = rect[3];

        // Pick a random point from the rec.
        int X = x1 + new Random().nextInt(x2 - x1 + 1);
        int Y = y1 + new Random().nextInt(y2 - y1 + 1);

        return new int[] {X, Y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
