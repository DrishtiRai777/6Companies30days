// https://leetcode.com/problems/repeated-dna-sequences/description/
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        int l = 0, r = 10;
        List<String> list = new ArrayList<>();
        while(r <= s.length()) {
            String substring = s.substring(l, r);
            map.put(substring, map.getOrDefault(substring, 0) + 1);
            l++;
            r++;
        }

        for(String dna : map.keySet()) {
            int val = map.get(dna);
            if (val > 1) {
                list.add(dna);
            }
        }

        return list;
    }
}
