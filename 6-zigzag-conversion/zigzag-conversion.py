class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1:
            return s
        rows = [''] * numRows
        targetRow = 0
        direction = 1
        for i in range(len(s)):
            rows[targetRow] += s[i]
            if (targetRow == 0 and direction == -1) or targetRow == numRows - 1:
                direction = -direction
            targetRow += direction
        res = ''
        for row in rows:
            res += row
        return res
