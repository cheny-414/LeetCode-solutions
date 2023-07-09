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

    public void add(String word) {
        TrieNode temp = root;
        for (char c : word.toCharArray()) {
            if (temp.children[c - 'a'] == null) {
                temp.children[c - 'a'] = new TrieNode();
            }
            temp = temp.children[c - 'a'];
        }
        temp.isWord = true;
    }

    public boolean searchWord(String word) {
        TrieNode temp = search(word);
        return temp != null && temp.isWord;
    }

    public boolean searchPrefix(String word) {
        TrieNode temp = search(word);
        return temp != null;
    }

    public TrieNode search(String word) {
        TrieNode temp = root;
        for (char c : word.toCharArray()) {
            if (temp.children[c - 'a'] == null) {
                return null;
            }
            temp = temp.children[c - 'a'];
        }
        return temp;
    }
}

class Solution {
    List<String> ans = new ArrayList<String>();
    int[][] directions = {{0,1 }, {1, 0}, {-1, 0}, {0, -1}};
    public List<String> findWords(char[][] board, String[] words) {
        if (board.length == 0 || board[0].length == 0 || words.length == 0) return ans;
        Trie trie = new Trie();

        for (String word : words) {
            trie.add(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                dfs(visited, trie, board, i, j, "");
            }
        }
        return ans;
    }

    public void dfs(boolean[][] visited, Trie trie, char[][] board, int i, int j, String soFar) {
        if (visited[i][j]) return;
        visited[i][j] = true;
        soFar = soFar + board[i][j];
        if (!trie.searchPrefix(soFar)) {
            visited[i][j] = false;
            return;
        }
        if (trie.searchWord(soFar)) {
            ans.add(soFar);
            TrieNode node = trie.search(soFar);
            node.isWord = false;
        }
        for (int[] dir : directions) {
            int nexti = i + dir[0];
            int nextj = j + dir[1];
            if (nexti >= 0. && nexti < board.length && nextj >= 0 && nextj < board[0].length) {
                dfs(visited, trie, board, nexti, nextj, soFar);
            }
        }
        visited[i][j] = false;
    }
}