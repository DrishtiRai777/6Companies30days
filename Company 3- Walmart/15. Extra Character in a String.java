class Node {
    Node links[] = new Node[26];
    boolean eow = false;

    Node() {}

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void setEnd() {
        eow = true;
    }

    boolean isEnd() {
        return eow;
    }
}

public class Trie {
    private static Node root;
    Trie() {
        root = new Node();
    }

    // Insertion
    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    // Search 
    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) return false;
            node = node.get(word.charAt(i));
        }
        return node.isEnd();
    }

    // Starts with
    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!node.containsKey(prefix.charAt(i))) return false;
            node = node.get(prefix.charAt(i));
        }
        return true;
    }
}

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Trie trie = new Trie();
        for (String word : dictionary) {
            trie.insert(word);
        }

        int dp[] = new int[s.length() + 1];
        Arrays.fill(dp, s.length()); 
        dp[0] = 0; 
        for(int i = 1; i <= s.length(); i++) {
            dp[i] = dp[i - 1] + 1; 
            for (int j = i - 1; j >= 0; j--) {
                if (trie.startsWith(s.substring(j, i))) {
                    if (trie.search(s.substring(j, i))) {
                        dp[i] = Math.min(dp[i], dp[j]); 
                    } else {
                        dp[i] = Math.min(dp[i], dp[j] + (i - j)); 
                    }
                }
            }
        }

        return dp[s.length()];
    }
}
