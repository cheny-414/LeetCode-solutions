class Solution:
    def numWays(self, n: int, k: int) -> int:
        #k      total(1)
        #k ** 2 total(2)
        #(k - 1) * total(i - 1) + 1 * (k - 1) * total(i - 2)
        one = k
        two = k ** 2
        ways = -1
        if n == 1:
            return one
        if n == 2:
            return two
        for i in range(2, n):
            ways = (k - 1) * (one + two)
            one = two
            two = ways
        return ways