class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        if numRows == 1:
            return [[1]]
        ans = [[1], [1, 1]]
        for i in range(2, numRows):
            row = [1]
            if ans:
                for j in range(0, i - 1):
                    row.append(ans[-1][j] + ans[-1][j + 1])
                row.append(1)
            ans.append(row)
        return ans