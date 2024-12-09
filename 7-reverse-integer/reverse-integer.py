class Solution:
    def reverse(self, x: int) -> int:
        sign = 1 if x > 0 else -1
        result = 0
        x = abs(x)
        while x:
            pop = x % 10
            x = x // 10
            result = result * 10 + pop
            if result > 2**31 - 1:
                return 0
        return result * sign