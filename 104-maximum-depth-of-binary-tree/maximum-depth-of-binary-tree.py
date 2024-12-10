# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        def getDepth(node):
            if node == None:
                return 0
            leftDepth = 0
            rightDepth = 0
            if node.left:
                leftDepth = getDepth(node.left)
            if node.right:
                rightDepth = getDepth(node.right) 
            return max(leftDepth, rightDepth) + 1
        return getDepth(root)