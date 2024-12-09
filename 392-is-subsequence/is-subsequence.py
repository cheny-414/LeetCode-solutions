class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        ps = 0
        pt = 0
        if len(s) > len(t):
            return False
        if not s:
            return True
        while pt < len(t):
            if ps == len(s):
                return True
            if s[ps] == t[pt]:
                ps += 1
                pt += 1
            else:
                pt += 1
        return ps == len(s)