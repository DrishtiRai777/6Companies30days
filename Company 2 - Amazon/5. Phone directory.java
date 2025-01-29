// https://www.geeksforgeeks.org/problems/phone-directory4628/1
class TrieNode {
    TrieNode[] links = new TrieNode[26];
    boolean isEnd = false;
    List<Integer> prefixIndices = new ArrayList<>();

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    TrieNode get(char ch) {
        return links[ch - 'a'];
    }
}

class Trie {
    TrieNode root;
    List<List<String>> ans = new ArrayList<>();

    Trie() {
        root = new TrieNode();
    }

    void insert(String word, int index) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
            node.prefixIndices.add(index);
        }
        node.isEnd = true;
    }

    void search(String word, List<String> contacts) {
        TrieNode node = root;
        List<String> temp = new ArrayList<>();
        int i;
        for (i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                break;
            }
            node = node.get(word.charAt(i));
            for (int index : node.prefixIndices) {
                temp.add(contacts.get(index));
            }
            Collections.sort(temp);
            ans.add(new ArrayList<>(temp));
            temp.clear();
        }

        temp.clear();
        temp.add("0");
        while (i++ < word.length()) ans.add(new ArrayList<>(temp));
    }
}

class Solution {
    public List<List<String>> displayContacts(int n, String[] contacts, String s) {
        Trie trie = new Trie();
        Set<String> uniqueContacts = new HashSet<>(Arrays.asList(contacts));
        List<String> contactList = new ArrayList<>(uniqueContacts);

        for (int i = 0; i < contactList.size(); i++) {
            trie.insert(contactList.get(i), i);
        }

        trie.search(s, contactList);
        return trie.ans;
    }
}
