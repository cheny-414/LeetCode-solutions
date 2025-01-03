# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def upsideDownBinaryTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root:
            return None
        ret = root
        while ret.left:
            ret = ret.left
        def helper(root):
            if not root or (not root.left and not root.right):
                return
            helper(root.left)
            temp = root.left
            temp.left = root.right
            temp.right = root
            root.left = None
            root.right = None
        helper(root)
        return ret
            