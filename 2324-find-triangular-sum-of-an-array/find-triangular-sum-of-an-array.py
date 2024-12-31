class Solution:
    def triangularSum(self, nums: List[int]) -> int:
        n = len(nums)
        def nLevel(n) -> list:
            #n choose k 
            answer = []
            last = 1
            answer.append(last)
            for k in range(1, n):
                curr = last * (n - k) // k
                answer.append(curr)
                last = curr
            return answer
        sum = 0
        coefficients = nLevel(n)
        for i, num in enumerate(nums):
            sum += num * coefficients[i]
        return sum % 10
        