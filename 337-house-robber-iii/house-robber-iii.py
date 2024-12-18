# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:
        dp = {}
        def helper(root, parentRobbed):
            if not root:
                return 0
            if not root.left and not root.right:
                return 0 if parentRobbed else root.val
            if (root, parentRobbed) in dp:
                return dp[(root, parentRobbed)]
            dontRobThisHouse = helper(root.left, False) + helper(root.right, False)
            if parentRobbed:
                dp[(root, parentRobbed)] = dontRobThisHouse
                return dontRobThisHouse
            else:
                robThisHouse = root.val + helper(root.left, True) + helper(root.right, True)
                dp[(root, parentRobbed)] = max(dontRobThisHouse, robThisHouse)
                return dp[(root, parentRobbed)]
        return max(helper(root, False), helper(root, True))
