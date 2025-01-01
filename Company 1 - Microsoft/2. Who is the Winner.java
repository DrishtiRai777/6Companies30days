// Problem link: https://leetcode.com/problems/find-the-winner-of-the-circular-game/
// A. First Way: Josephus Problem 
class Solution {
    public int solve(int n, int k) {
        if(n==1) return 0;
        return (solve(n-1, k) + k ) % n;
    }
    public int findTheWinner(int n, int k) {
        return solve(n, k)+1; 
    }
}

// B. Second Way - Using a Queue
class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            q.add(i);
        }

        // Simulate the circular Traversal
        while(q.size() > 1) {
            int cnt = k;
            while(cnt > 1) {
                // If not lost... put it at the end of the queue and reduce cnt
                int curr = q.remove();
                q.add(curr);
                cnt--;
            }

            q.remove(); // remove the ele.
        }

        return q.peek();
    }
}
