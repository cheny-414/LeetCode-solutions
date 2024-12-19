class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        n = len(grid)
        dirs = ((0, 1), (1, 0), (0, -1), (-1, 0))
        def canReach(days):
            visited = set()
            q = deque([(0, 0)])
            while q:
                curr = q.popleft()
                if curr[0] == n - 1 and curr[1] == n - 1:
                    return True
                for di in dirs:
                    neii = curr[0] + di[0]
                    neij = curr[1] + di[1]
                    if 0 <= neii < n and 0 <= neij < n and grid[neii][neij] <= days and (neii, neij) not in visited:
                        q.append((neii, neij))
                        visited.add((neii, neij))
            return False
        left = grid[0][0]
        right = 2500
        result = -1
        while left <= right:
            mid = left + (right - left) // 2
            if canReach(mid):
                result = mid
                right = mid - 1
            else:
                left = mid + 1
        return result