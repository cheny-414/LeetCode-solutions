# """
# This is BinaryMatrix's API interface.
# You should not implement it, or speculate about its implementation
# """
#class BinaryMatrix(object):
#    def get(self, row: int, col: int) -> int:
#    def dimensions(self) -> list[]:

class Solution:
    def leftMostColumnWithOne(self, binaryMatrix: 'BinaryMatrix') -> int:
        #0 0 0 0 0
        #0 1 1 1 1
        #0 0 0 1 1
        #0 0 0 0 0
        #1 1 1 1 1
        #0 0 0 1 1
        dimensions = binaryMatrix.dimensions()
        ans = -1
        left = 0
        right = dimensions[1] - 1
        def has_one(col):
            for i in range(dimensions[0]):
                if binaryMatrix.get(i, col) == 1:
                    return True
            return False
        while left <= right:
            mid = left + (right - left) // 2
            if has_one(mid):
                ans = mid
                right = mid - 1
            else:
                left = mid + 1
        return ans
