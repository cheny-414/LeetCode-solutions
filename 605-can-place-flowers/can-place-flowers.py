class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        flowerbed = [0] + flowerbed + [0]
        streak = 0
        flower = 0
        for spot in flowerbed:
            if spot == 0:
                streak += 1
            else:
                flower += (streak - 1) // 2
                streak = 0
        flower += (streak - 1) // 2
        return flower >= n