# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def flipEquiv(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
        dp = {}
        def sameTree(root1, root2):
            if not root1 and not root2:
                return True
            if root1 and root2:
                if (root1.val, root2.val) in dp:
                    return dp[(root1.val, root2.val)]
                noSwap = sameTree(root1.left, root2.left) and sameTree(root1.right, root2.right)
                swap = sameTree(root1.left, root2.right) and sameTree(root1.right, root2.left)
                dp[(root1.val, root2.val)] = root1.val == root2.val and (noSwap or swap)
                return dp[(root1.val, root2.val)]
            return False
        return sameTree(root1, root2)