class Solution:
    def countAndSay(self, n: int) -> str:
        # 1
        # 11
        # 21
        # 1211
        # 111221
        def rle(s):
            count = 1
            prev = s[0]
            res = ''
            for i in range(1, len(s)):
                char = s[i]
                if char == prev:
                    count += 1
                else:
                    res += (str(count))
                    res += (prev)
                    prev = char
                    count = 1
            res += (str(count))
            res += (prev)
            return res
        dp = []
        dp.append('1')
        for i in range(1, n):
            dp.append(rle(dp[-1]))
        return dp[-1]