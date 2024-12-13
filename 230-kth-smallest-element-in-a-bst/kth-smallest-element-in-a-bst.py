# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        count = 0
        result = -1
        def inorder(root):
            nonlocal count
            nonlocal result
            if not root:
                return
            inorder(root.left)
            count += 1
            if count == k:
                result = root.val
                return
            inorder(root.right)
        inorder(root)
        return result
        
            