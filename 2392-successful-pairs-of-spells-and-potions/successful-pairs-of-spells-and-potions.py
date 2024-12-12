class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        potions.sort()
        result = []
        for spell in spells:
            need = -(-success // spell)
            left = 0
            right = len(potions) - 1
            answer = 0
            while left <= right:
                mid = left + (right - left) // 2
                if potions[mid] >= need:
                    right = mid - 1
                    answer = max(answer, len(potions) - mid)
                else:
                    left = mid + 1
            result.append(answer)
        return result