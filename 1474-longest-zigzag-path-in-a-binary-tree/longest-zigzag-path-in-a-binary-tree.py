# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def longestZigZag(self, root: Optional[TreeNode]) -> int:
        dp = {}
        def helper(node, direction):
            answer = 0
            if not node:
                return 0
            if node in dp.keys() and direction in dp[node]:
                return dp[node][direction]
            if direction == 'left':
                answer = 1 + helper(node.right, 'right')
            else:
                answer = 1 + helper(node.left, 'left')
            if node in dp.keys():
                dp[node][direction] = answer
            else:
                dp[node] = {}
                dp[node][direction] = answer
            return answer
        def dfs(node):
            if not node:
                return
            helper(node, 'left')
            helper(node, 'right')
            dfs(node.left)
            dfs(node.right)
        dfs(root)
        result = 0
        for node in dp.keys():
            for direction in dp[node]:
                result = max(result, dp[node][direction])
        return result - 1