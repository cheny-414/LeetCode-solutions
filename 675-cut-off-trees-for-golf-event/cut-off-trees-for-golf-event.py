class Solution:
    def cutOffTree(self, forest: List[List[int]]) -> int:
        m = len(forest)
        n = len(forest[0])
        pq = []
        total = 0
        def bfs(startX, startY, endX, endY):
            queue = deque([(startX, startY, 0)])
            seen = set((startX, startY))
            while queue:
                currX, currY, steps = queue.popleft()
                #seen.add((currX, currY))
                if currX == endX and currY == endY:
                    forest[currX][currY] = 1
                    return steps
                for a,b in [[0, 1], [1, 0], [0, -1], [-1, 0]]:
                    nextX = currX + a
                    nextY = currY + b
                    if 0 <= nextX < m and 0 <= nextY < n and forest[nextX][nextY] >= 1 and (nextX, nextY) not in seen:
                        queue.append((nextX, nextY, steps + 1))
                        seen.add((nextX, nextY))
            return -1
        for i in range(m):
            for j in range(n):
                height = forest[i][j]
                if height > 1:
                    heappush(pq, (height, i, j))

        currX, currY = 0, 0
        while pq:
            height, treeX, treeY = heappop(pq)
            steps = bfs(currX, currY, treeX, treeY)
            if steps == -1:
                return -1
            total += steps
            currX = treeX
            currY = treeY
        return total
