class Solution:
    def canMakeSubsequence(self, str1: str, str2: str) -> bool:
        p2 = 0
        for i in range(len(str1)):
            if str1[i] == str2[p2] or ord(str1[i]) + 1 == ord(str2[p2]) or str1[i] == 'z' and str2[p2] == 'a':
                p2 += 1
                if p2 == len(str2):
                    return True
        return False