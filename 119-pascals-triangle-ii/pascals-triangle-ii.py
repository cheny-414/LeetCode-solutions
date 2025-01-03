class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        res = [1]
        curr = 1
        for i in range(1, rowIndex + 1):
            curr = curr * (rowIndex + 1 - i) // i
            res.append(curr)
        return res