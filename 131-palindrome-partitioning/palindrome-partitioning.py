class Solution:
    def partition(self, s: str) -> List[List[str]]:
        dp = [[0] * (len(s) + 1) for _ in range(len(s) + 1)] #1 = True, 2 = False
        res = []
        def isPalindrome(start, end):
            if start > end:
                return True
            if start == end:
                return True
            if dp[start][end] != 0:
                return dp[start][end] == 1
            if s[start] == s[end]:
                dp[start][end] = 1 if isPalindrome(start + 1, end - 1) else 2
                return dp[start][end] == 1
            else:
                dp[start][end] = 2
                return False
        def helper(start, end):
            ret = []
            # if start > end:
            #     return ret
            for i in range(start, end + 1):
                if isPalindrome(start, i):
                    if i + 1 < len(s):
                        parts = helper(i + 1, end)
                        for part in parts:
                            newPart = []
                            newPart.append(s[start:i+1])
                            newPart.extend(part)
                            ret.append(newPart)
                    else:
                        ret.append([s[start:i+1]])
            return ret
        return helper(0, len(s) - 1)
                    
