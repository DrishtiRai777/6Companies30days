// Problem: https://leetcode.com/problems/first-unique-character-in-a-string/description/
class Pair {
    int first; // freq
    int second; // last index it occured

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Pair> map = new HashMap<>();
        int uniqChar = Integer.MAX_VALUE; // non repeating char index

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Pair pair = map.getOrDefault(ch, new Pair(0, i));
            map.put(ch, new Pair(pair.first + 1, i));
        }

        for(Character ch : map.keySet()) {
            Pair p = map.get(ch);
            int freq = p.first;
            int idx = p.second;

            if(freq == 1 && idx < uniqChar) 
                uniqChar = idx;
        }

        return uniqChar == Integer.MAX_VALUE ? -1 : uniqChar;
    }
}


// Solution 2
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }   

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(map.get(ch) == 1)
                return i;
        }

        return -1;
    }
}
