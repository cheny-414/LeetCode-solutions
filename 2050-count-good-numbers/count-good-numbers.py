class Solution:
    def countGoodNumbers(self, n: int) -> int:
        MOD = 10**9 + 7
        def countGood(power, x):
            if power == 0:
                return 1
            elif power % 2 == 0:
                return countGood(power // 2, x**2 % MOD)
            return x * countGood(power - 1, x) % MOD
        return 5 ** (n % 2) * countGood(n // 2, 20) % MOD