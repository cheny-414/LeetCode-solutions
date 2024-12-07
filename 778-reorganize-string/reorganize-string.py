class Solution:
    def reorganizeString(self, s: str) -> str:
        counts = Counter(s)
        pq = []
        result = ""
        for char, count in counts.items():
            heapq.heappush(pq, [-count, char])

        while pq:
            popped = heapq.heappop(pq)
            if len(result) == 0 or popped[1] != result[-1]:
                result += popped[1]
                if popped[0] + 1 != 0:
                    heapq.heappush(pq, [popped[0] + 1, popped[1]])
            else:
                if not pq: return ""
                popped2 = heapq.heappop(pq)
                result += popped2[1]
                if popped2[0] + 1 != 0:
                    heapq.heappush(pq, [popped2[0] + 1, popped2[1]])
                heapq.heappush(pq, popped)
        return result
