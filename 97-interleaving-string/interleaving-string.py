class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        dp = {}
        if len(s1) + len(s2) != len(s3):
            return False
        def canInterleave(index, index1, index2):
            if index >= len(s3):
                return index1 == len(s1) and index2 == len(s2)
            if index1 >= len(s1):
                return s2[index2:] == s3[index:]
            if index2 >= len(s2):
                return s1[index1:] == s3[index:]
            if (index, index1, index2) in dp:
                return dp[(index, index1, index2)]
            res = False
            #use s1
            if s1[index1] == s3[index]:
                res |= canInterleave(index + 1, index1 + 1, index2)
            #use s2
            if s2[index2] == s3[index]:
                res |= canInterleave(index + 1, index1, index2 + 1)
            dp[(index, index1, index2)] = res
            return res
        return canInterleave(0, 0, 0)
