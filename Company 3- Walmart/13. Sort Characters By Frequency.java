// Problem: https://leetcode.com/problems/sort-characters-by-frequency/description/
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(Character ch: s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Bucket Sort
        List<Character>[] buck = new List[s.length() + 1];
        for(Character key: map.keySet()) {
            int freq = map.get(key);
            if(buck[freq] == null) 
                buck[freq] = new ArrayList<>();
            
            buck[freq].add(key);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=buck.length-1; i>=0; i--) {
            if(buck[i] != null) {
                for(char ch: buck[i]) {
                    for(int j=0; j<i; j++) 
                        sb.append(ch);
                }
            }
        }

        return sb.toString();
    }
}
