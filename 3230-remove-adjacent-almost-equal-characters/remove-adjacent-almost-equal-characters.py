class Solution:
    def removeAlmostEqualCharacters(self, word: str) -> int:
        def almost(i, j):
            return abs(ord(word[i]) - ord(word[j])) <= 1
        res = 0
        i = 1
        while i < len(word):
            if almost(i, i - 1):
                res += 1
                i += 2
            else:
                i += 1
        return res
            