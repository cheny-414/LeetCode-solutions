class Solution:
    def nthSuperUglyNumber(self, n: int, primes: List[int]) -> int:
        nums = primes.copy()
        numsSet = set(nums)
        p = 1
        for i in range(n - 1):
            p = heappop(nums)
            for prime in primes:
                #if p * prime not in numsSet:
                heappush(nums, p * prime)
                #numsSet.add(p * prime)
                if p % prime == 0:
                    break
        return p