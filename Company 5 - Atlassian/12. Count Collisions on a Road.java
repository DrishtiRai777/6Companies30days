// https://leetcode.com/problems/count-collisions-on-a-road/description/
class Solution {
    public int countCollisions(String dir) {
        Stack<Character> s = new Stack<>();
        int cnt = 0;
        for(char ch: dir.toCharArray()) {
            if(!s.isEmpty() && ch == 'L' && s.peek() == 'R') {
                cnt += 2;
                s.pop();

                while(!s.isEmpty() && s.peek() == 'R') {
                    cnt += 1;
                    s.pop();
                }

                s.push('S');
            }

            else if(!s.isEmpty() && ch == 'L' && s.peek() == 'S') {
                cnt += 1;
                s.push('S');
            }

            else if(!s.isEmpty() && ch == 'S' && s.peek() == 'R') {
                while(!s.isEmpty() && s.peek() == 'R') {
                    cnt += 1;
                    s.pop();
                }
                s.push('S');
            }

            else s.push(ch);
        }
        return cnt;
    }
}
