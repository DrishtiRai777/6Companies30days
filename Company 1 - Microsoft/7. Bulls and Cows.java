// Problem: https://leetcode.com/problems/bulls-and-cows/
class Solution {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        HashMap<Character, Integer> map1 = new HashMap<>(); 
        HashMap<Character, Integer> map2 = new HashMap<>(); 
        int bulls = 0, cows = 0;

        for(int i = 0; i < n; i++) {
            char ch1 = secret.charAt(i);
            char ch2 = guess.charAt(i);

            if(ch1 == ch2) bulls++;
            else {
                map1.put(ch1, map1.getOrDefault(ch1, 0) + 1);
                map2.put(ch2, map2.getOrDefault(ch2, 0) + 1);
            }
        }

        // Iterating over the Guess HashMap
        for(Character key: map2.keySet()) {
            if(map1.containsKey(key)) 
                cows += Math.min(map1.get(key), map2.get(key));
            
        }

        String res = bulls + "A" + cows + "B";
        return res;
    }
}
