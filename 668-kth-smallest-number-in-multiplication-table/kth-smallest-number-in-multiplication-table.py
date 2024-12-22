class Solution:
    def findKthNumber(self, m: int, n: int, k: int) -> int:
        def num_of_numbers_lte_x(x):
            res = 0
            for i in range(m):
                cand = 0
                num1 = i + 1
                left = 1
                right = n
                while left <= right:
                    num2 = left + (right - left) // 2
                    if num1 * num2 <= x:
                        cand = num2
                        left = num2 + 1
                    else:
                        right = num2 - 1
                res += cand
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