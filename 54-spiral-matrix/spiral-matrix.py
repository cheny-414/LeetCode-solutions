class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        m = len(matrix)
        n = len(matrix[0])
        res = []
        curr = (0,0)
        dirs = ((0, 1), (1, 0), (0, -1), (-1, 0))
        currDir = 0
        while 0 <= curr[0] < m and 0 <= curr[1] < n and matrix[curr[0]][curr[1]] != -101:
            res.append(matrix[curr[0]][curr[1]])
            matrix[curr[0]][curr[1]]  = -101
            nexti = curr[0] + dirs[currDir % 4][0]
            nextj = curr[1] + dirs[currDir % 4][1]
            if nexti < 0 or nexti > m - 1 or nextj < 0 or nextj > n - 1 or matrix[nexti][nextj] == -101:
                currDir += 1
            curr = (curr[0] + dirs[currDir % 4][0], curr[1] + dirs[currDir % 4][1])
        return res