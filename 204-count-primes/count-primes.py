class Solution:
    def countPrimes(self, n: int) -> int:
        if n <= 1:
            return 0
        isPrime = [True] * (n)
        for i in range(2, int(n**0.5) + 1):
            if isPrime[i]:
                for j in range(i * i, n, i):
                    isPrime[j] = False
        return sum([1 for x in isPrime if x]) - 2