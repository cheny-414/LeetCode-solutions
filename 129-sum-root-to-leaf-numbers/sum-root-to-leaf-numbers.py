# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        sum = 0
        def helper(root, currVal):
            nonlocal sum
            if not root:
                return
            val = currVal * 10 + root.val
            if not root.left and not root.right:
                sum += val
                return
            helper(root.left, val)
            helper(root.right, val)
        helper(root, 0)
        return sum