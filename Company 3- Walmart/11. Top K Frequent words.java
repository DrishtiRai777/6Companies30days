// Problem: https://leetcode.com/problems/top-k-frequent-words/
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((w1, w2) -> 
            map.get(w1).equals(map.get(w2)) ? w1.compareTo(w2) : map.get(w2) - map.get(w1)
        );

        for(String word: map.keySet()) {
            pq.offer(word);
        }

        List<String> list = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            list.add(pq.poll());
        }
        
        return list;
    }
}
