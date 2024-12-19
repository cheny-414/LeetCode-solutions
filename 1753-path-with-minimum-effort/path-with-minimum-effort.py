class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        m = len(heights)
        n = len(heights[0])
        dirs = ((0, 1), (1, 0), (0, -1), (-1, 0))
        costs = [[float('inf')] * n for _ in range(m)]
        costs[0][0] = 0
        visited = [[False] * n for _ in range(m)]
        #visited[0][0] = True
        pq = [(0, 0, 0)] # cost, i, j
        while pq:
            cost, i, j = heappop(pq)
            for di in dirs:
                nexti = i + di[0]
                nextj = j + di[1]
                if 0 <= nexti < m and 0 <= nextj < n:
                    nextCost = abs(heights[nexti][nextj] - heights[i][j])
                    maxCost = max(nextCost, costs[i][j])
                    if costs[nexti][nextj] > maxCost:
                        costs[nexti][nextj] = maxCost
                        heappush(pq, (maxCost, nexti, nextj))
        return costs[-1][-1]