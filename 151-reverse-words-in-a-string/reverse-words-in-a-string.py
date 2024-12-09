class Solution:
    def reverseWords(self, s: str) -> str:
        res = deque()
        words = s.split()

        for word in words:
            res.appendleft(word)
        return ' '.join(res)