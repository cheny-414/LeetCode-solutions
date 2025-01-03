class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        if rowIndex == 0:
            return [1]
        if rowIndex == 1:
            return [1, 1]
        res = [1]
        curr = 1
        for i in range(1, rowIndex + 1):
            curr = curr * (rowIndex + 1 - i) // i
            res.append(curr)
        return res