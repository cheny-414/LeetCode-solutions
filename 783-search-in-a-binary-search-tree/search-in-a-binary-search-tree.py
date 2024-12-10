# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def searchBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        def dfs(root, val):
            if not root:
                return None
            if root.val == val:
                return root
            if root.val < val:
                return dfs(root.right, val)
            else:
                return dfs(root.left, val)
        return dfs(root, val)
            