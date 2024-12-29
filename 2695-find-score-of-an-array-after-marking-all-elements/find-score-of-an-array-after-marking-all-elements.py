class Solution:
    def findScore(self, nums: List[int]) -> int:
        pq = []
        marked = set()
        for i, num in enumerate(nums):
            heappush(pq, (num, i))
        score = 0
        added = 0
        while added < len(nums):
            num, index = heappop(pq)
            if index in marked:
                continue
            score += num
            marked.add(index)
            added += 1
            if index > 0 and index - 1 not in marked:
                marked.add(index - 1)
                added += 1
            if index < len(nums) - 1 and index + 1 not in marked:
                marked.add(index + 1)
                added += 1
        return score