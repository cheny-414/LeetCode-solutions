class Solution:
    def isOneEditDistance(self, s: str, t: str) -> bool:
        if len(s) == 0:
            return len(t) == 1
        if len(t) == 0:
            return len(s) == 1
        if s[0] == t[0]:
            return self.isOneEditDistance(s[1:], t[1:])
        else:
            return s == t[1:] or t == s[1:] or s[1:] == t[1:]
