// https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
class Node {
    Node[] links = new Node[26];
    boolean eow;

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

class Trie {
    Node root;

    Trie() {
        root = new Node();
    }

    // Add words
    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    // Search words with optional wildcard '.'
    public boolean search(String word) {
        return searchInNode(word, 0, root);
    }

    private boolean searchInNode(String word, int idx, Node node) {
        if(idx == word.length()) return node.isEnd();

        char ch = word.charAt(idx);
        if(ch == '.') {
            // Explore all possibilities...
            for(int i=0; i<26; i++) {
                if(node.links[i] != null && searchInNode(word, idx+1, node.links[i])) return true;
            }
            return false;
        }

        else {
            if(!node.containsKey(ch)) return false;
            return searchInNode(word, idx + 1, node.get(ch));
        }
    }
}

class WordDictionary {
    Trie trie;

    public WordDictionary() {
        trie = new Trie();
    }

    public void addWord(String word) {
        trie.insert(word);
    }

    public boolean search(String word) {
        return trie.search(word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
