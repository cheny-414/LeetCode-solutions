class Solution:
    def connectSticks(self, sticks: List[int]) -> int:
        if len(sticks) == 1:
            return 0
        pq = sorted(sticks)
        cost = 0
        while len(pq) > 1:
            currCost = heappop(pq) + heappop(pq)
            cost += currCost
            heappush(pq, currCost)
        return cost
        