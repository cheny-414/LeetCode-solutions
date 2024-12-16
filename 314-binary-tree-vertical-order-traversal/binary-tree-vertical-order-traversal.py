# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        q = deque([(root, 0)])
        result = defaultdict(list)
        ret = []
        minColumn = 0
        maxColumn = 0
        while q:
            curr, column = q.popleft()
            if not curr:
                continue
            result[column].append(curr.val)
            if column < minColumn:
                minColumn = column
            if column > maxColumn:
                maxColumn = column
            q.append((curr.left, column - 1))
            q.append((curr.right, column + 1))
        for i in range(minColumn, maxColumn + 1):
            if result[i]:
                ret.append(result[i])
        return ret