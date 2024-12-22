class Solution:
    def findKthNumber(self, m: int, n: int, k: int) -> int:
        def num_of_numbers_lte_x(x):
            res = 0
            for i in range(1, min(x, m) + 1):
                res += min(x // i, n)
            return res
        print(num_of_numbers_lte_x(2))
        left = 1
        right = m * n
        res = -1
        while left <= right:
            mid = left + (right - left) // 2
            if num_of_numbers_lte_x(mid) >= k:
                res = mid
                right = mid - 1
            else:
                left = mid + 1
        return res