class Solution:
    def nthUglyNumber(self, n: int) -> int:
        ugly = 1
        primes = [2, 3, 5]
        candidates = primes.copy()
        candSet = set(candidates)
        for i in range(n - 1):
            ugly = heappop(candidates)
            for prime in primes:
                if ugly * prime not in candSet:
                    heappush(candidates, ugly * prime)
                    candSet.add(ugly * prime)
        return ugly