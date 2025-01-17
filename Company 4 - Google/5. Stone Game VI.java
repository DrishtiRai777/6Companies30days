// https://leetcode.com/problems/stone-game-vi/description/
class Pair {
    int first; //A[i] + B[i]
    int second; // idx

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int stoneGameVI(int[] A, int[] B) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x1, x2) -> x2.first - x1.first);
        for(int i=0; i<A.length; i++) {
            pq.add(new Pair((A[i] + B[i]), i));
        }

        int alice = 0, bob = 0, turn = 0;
        // Alice pay at even turn , bob at odd  
        while(!pq.isEmpty()) {
            Pair p = pq.remove();
            int idx = p.second;

            if(turn%2 == 0) alice += A[idx];
            else bob += B[idx];

            turn++;
        }

        if(alice > bob) return 1;
        if(alice < bob) return -1;
        return 0; // draw;
    }
}
