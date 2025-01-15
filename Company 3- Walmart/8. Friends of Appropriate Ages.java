// Problem: https://leetcode.com/problems/friends-of-appropriate-ages/
class Solution {
    public boolean isFriendReq(int x, int y) {
        if(y <= 0.5*x+7) return false;
        if(y > x) return false;
        if(y > 100 && x < 100) return false;

        return true;
    }
    
    public int numFriendRequests(int[] ages) {
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int age: ages) {
            map.put(age, map.getOrDefault(age, 0) + 1);
        }

        for(Integer a: map.keySet()) {
            for(Integer b: map.keySet()) {
                if(a != b && isFriendReq(a, b)) 
                    cnt += map.get(a) * map.get(b);
                else if(a == b && isFriendReq(a, b)) 
                    cnt += map.get(a) * (map.get(b) -1) ;
            }
        }
        return cnt;
    }
}
