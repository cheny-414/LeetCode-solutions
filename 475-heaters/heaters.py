class Solution:
    def findRadius(self, houses: List[int], heaters: List[int]) -> int:
        houses.sort()
        heaters.sort()
        def canHeat(radius):
            for house in houses:
                nearestHeater = bisect_left(heaters, house)
                if nearestHeater < len(heaters):
                    if house < heaters[nearestHeater] - radius:
                        if nearestHeater == 0 or house > heaters[nearestHeater - 1] + radius:
                            return False
                elif heaters[nearestHeater - 1] + radius < house:
                    return False
            return True
        left = 0
        right = 10**9
        ans = right
        while left <= right:
            mid = left + (right - left) // 2
            if canHeat(mid):
                ans = mid
                right = mid - 1
            else:
                left = mid + 1
        return ans