# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        def helper(node, maximum):
            good = 0
            if node.val >= maximum:
                good += 1
            if node.left:
                good += helper(node.left, max(maximum, node.val))
            if node.right:
                good += helper(node.right, max(maximum, node.val))
            return good
        return helper(root, -float('inf'))