//Problem:  https://www.geeksforgeeks.org/problems/nuts-and-bolts-problem0431/1
class Solution {
    void matchPairs(int n, char nuts[], char bolts[]) {
        char seq[] = {'!', '#', '$', '%', '&', '*', '?', '@', '^'};
        HashSet<Character> set = new HashSet<>();
        for(char ch: nuts) 
            set.add(ch);
        
        int idx = 0;
        for(int i=0; i<seq.length; i++) {
            if(set.contains(seq[i]) == true) {
                nuts[idx] = seq[i];
                bolts[idx++] = seq[i];
            }
        }
    }
}
