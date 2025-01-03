class Solution:
    def reverseWords(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        def reverse(start, end):
            p1 = start
            p2 = end
            while p1 < p2:
                s[p1], s[p2] = s[p2], s[p1]
                p1 += 1
                p2 -= 1
        reverse(0, len(s) - 1)
        left = 0
        for i in range(len(s)):
            if s[i] == " ":
                reverse(left, i - 1)
                left = i + 1
        reverse(left, len(s) - 1)
        