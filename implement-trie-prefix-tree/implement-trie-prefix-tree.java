class TrieNode {
    public boolean isWord;
    public TrieNode[] children;

    public TrieNode() {
        isWord = false;
        children = new TrieNode[26];
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode temp = root;
        for (char c : word.toCharArray()) {
            if (temp.children[c - 'a'] == null) {
                temp.children[c - 'a'] = new TrieNode();
            }
            temp = temp.children[c - 'a'];
        }
        temp.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode temp = searchPrefix(word);
        return temp != null && temp.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode temp = searchPrefix(prefix);
        return temp != null;
    }

    public TrieNode searchPrefix(String key) {
        TrieNode temp = root;
        for (char c : key.toCharArray()) {
            if (temp.children[c - 'a'] == null) {
                return null;
            }
            temp = temp.children[c - 'a'];
        }
        return temp;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */