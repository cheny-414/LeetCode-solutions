# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getMinimumDifference(self, root: Optional[TreeNode]) -> int:
        def getSuccessor(root):
            if not root:
                return float("inf")
            root = root.right
            while root and root.left:
                root = root.left
            return root.val if root else float("inf")

        def getPredecessor(root):
            if not root:
                return float("inf")
            root = root.left
            while root and root.right:
                root = root.right
            return root.val if root else float("inf")

        minDiff = float("inf")

        def helper(root):
            nonlocal minDiff
            if not root:
                return
            diffLeft = abs(getPredecessor(root) - root.val)
            diffRight = abs(getSuccessor(root) - root.val)
            minDiff = min(minDiff, diffLeft, diffRight)
            helper(root.left)
            helper(root.right)

        helper(root)
        return minDiff
