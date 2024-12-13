class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        q = deque([beginWord])
        visited = {beginWord}
        wordSet = set(wordList)
        steps = 1

        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if curr == endWord:
                    return steps
                for j in range(len(beginWord)):
                    for k in range(26):
                        newWord = curr[:j] + chr(ord('a') + k) + curr[j + 1:]
                        if newWord not in visited and newWord in wordSet:
                            q.append(newWord)
                            visited.add(newWord)
            steps += 1
        return 0
