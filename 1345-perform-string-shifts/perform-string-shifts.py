class Solution:
    def stringShift(self, s: str, shift: List[List[int]]) -> str:
        k = 0
        for sh in shift:
            k += sh[1] if sh[0] == 1 else -sh[1]
        k %= len(s)
        if k < 0:
            k = -k
            ret = s[k:] + s[:k]
        elif k > 0:
            ret = s[len(s) - k:] + s[:len(s) - k]
        else:
            return s

        return ret
        #a b c d
        #b c d a