# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        def helper(node):
            if not node:
                return (0, 0, 0)
            if not node.left and not node.right:
                return (0, 0, node.val)
            maxLeft = maxRight = 0
            leftBest = rightBest = -float('inf')
            if node.left:
                leftMaxLeft, leftMaxRight, leftBest = helper(node.left)
                maxLeft = max(maxLeft, node.left.val + max(leftMaxLeft, leftMaxRight))
            if node.right:
                rightMaxLeft, rightMaxRight, rightBest = helper(node.right)
                maxRight = max(maxRight, node.right.val + max(rightMaxLeft, rightMaxRight))
            best = max(leftBest, rightBest, maxLeft + maxRight + node.val)
            return (maxLeft, maxRight, best)
        return helper(root)[2]