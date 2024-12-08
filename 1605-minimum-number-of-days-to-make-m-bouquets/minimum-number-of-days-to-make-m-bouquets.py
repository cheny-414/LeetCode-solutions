class Solution:
    def minDays(self, bloomDay: List[int], m: int, k: int) -> int:
        def canMake(days):
            bouquets = 0
            adjacent = 0
            for bloom in bloomDay:
                if bloom <= days:
                    adjacent += 1
                    if adjacent == k:
                        bouquets += 1
                        adjacent = 0
                else:
                    adjacent = 0
            return bouquets >= m
        
        left = 1
        right, max_days = max(bloomDay), max(bloomDay)
        min_days = float('inf')
        while left <= right:
            mid = left + (right - left) // 2
            if canMake(mid):
                min_days = mid
                right = mid - 1
            else:
                left = mid + 1
        return min_days if min_days <= max_days else -1
