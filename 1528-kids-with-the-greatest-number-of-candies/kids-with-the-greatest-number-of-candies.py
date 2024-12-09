class Solution:
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        maxCandies = max(candies)
        result = []
        for kid in candies:
            if kid + extraCandies >= maxCandies:
                result.append(True)
            else:
                result.append(False)
        return result