// https://leetcode.com/problems/count-words-obtained-after-adding-a-letter/
class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        HashSet<Integer> set = new HashSet<>();
        for(String word: startWords) {
            int hash = 0;
            for(int i=0; i<word.length(); i++) {
                char ch = word.charAt(i);
                int bit = ch - 'a';
                // Set bit corresponding to that char
                hash = hash | (1 << bit);
            }
            set.add(hash);
        }

        // Compare with target words
        int cnt = 0;
        for(String word: targetWords) {
            int hash = 0; // Generate Hash for that word
            for(int i=0; i<word.length(); i++) {
                char ch = word.charAt(i);
                int bit = ch - 'a';
                hash = hash | (1 << bit);
            }

            // Turn off each bit and see if it contains in the set or not.... If yes - break , if not restore it
            for(int i=0; i<word.length(); i++) {
                char ch = word.charAt(i);
                int bit = ch - 'a';
                hash = hash & ~(1 << bit);

                if(set.contains(hash)) {
                    cnt++;
                    break;
                }
                else hash = hash | (1 << bit); // restore
            }
        }

        return cnt;
    }
}
