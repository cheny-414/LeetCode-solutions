# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        levels = {}
        def dfs(node, level):
            if not node:
                return
            if level not in levels:
                levels[level] = node.val
            else:
                levels[level] += node.val
            dfs(node.left, level + 1)
            dfs(node.right, level + 1)
        dfs(root, 1)
        answer = -1
        maxSum = -float('inf')
        for x in levels.keys():
            if levels[x] > maxSum:
                answer = x
                maxSum = levels[x]
        return answer