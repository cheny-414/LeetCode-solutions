class TrieNode:
    def __init__(self, parent=None):
        self.parent = parent
        self.children = {}
        self.isWord = False
class Trie:
    def __init__(self):
        self.root = TrieNode()
        self.pointer = self.root
    def insert(self, word: str):
        curr = self.root
        for char in word:
            if char in curr.children:
                curr = curr.children[char]
            else:
                curr.children[char] = TrieNode(curr)
                curr = curr.children[char]
        curr.isWord = True
    # def startsWith(self, prefix):
    #     curr = self.root
    #     for char in prefix:
    #         if char not in curr.children:
    #             return False
    #         curr = curr.children[char]
    #     return True
    def hasNextChar(self, char):
        if char in self.pointer.children:
            self.pointer = self.pointer.children[char]
            self.last = self.pointer
            return True
        return False
    def resetPointer(self):
        self.pointer = self.pointer.parent
class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        m = len(board)
        n = len(board[0])
        directions = ((0, 1), (1, 0), (-1, 0), (0, -1))
        res = set()
        visited = set()
        word_set = set(words)
        trie = Trie()
        for word in words:
            trie.insert(word)
        def dfs(row, col, prefix):
            if not trie.hasNextChar(board[row][col]):
                return
            if prefix in word_set:
                res.add(prefix)
            visited.add((row, col))
            for di in directions:
                next_row = row + di[0]
                next_col = col + di[1]
                if 0 <= next_row < m and 0 <= next_col < n and (next_row, next_col) not in visited:
                    dfs(next_row, next_col, prefix + board[next_row][next_col])
            visited.remove((row, col))
            trie.resetPointer()
        for i in range(m):
            for j in range(n):
                dfs(i, j, board[i][j])
                #visited.clear()
        return list(res)