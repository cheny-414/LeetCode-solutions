class Solution:
    def minArraySum(self, nums: List[int], k: int, op1: int, op2: int) -> int:
        dp = [[[float('inf')] * (op2 + 1) for _ in range(op1 + 1)] for _ in range(len(nums))]

        def solve(start, op1Left, op2Left):
            if start > len(nums) - 1:
                return 0
            value = float('inf')
            if dp[start][op1Left][op2Left] != float('inf'):
                return dp[start][op1Left][op2Left]
            #dont do anything
            value = min(nums[start] + solve(start + 1, op1Left, op2Left), value)

            #use op1
            if op1Left > 0:
                value = min(-(-nums[start] // 2) + solve(start + 1, op1Left - 1, op2Left), value)

            #use op2
            if nums[start] >= k and op2Left > 0:
                value = min(nums[start] - k + solve(start + 1, op1Left, op2Left - 1), value)

            #use op1 and then op2
            if -(-nums[start] // 2) >= k and op1Left > 0 and op2Left > 0:
                value = min(-(-nums[start] // 2) - k + solve(start + 1, op1Left - 1, op2Left - 1), value)

            #use op2 and then op1
            if nums[start] >= k and op1Left > 0 and op2Left > 0:
                value = min(-(-(nums[start] - k) // 2) + solve(start + 1, op1Left - 1, op2Left - 1), value)
            dp[start][op1Left][op2Left] = value
            return value
        return solve(0, op1, op2)