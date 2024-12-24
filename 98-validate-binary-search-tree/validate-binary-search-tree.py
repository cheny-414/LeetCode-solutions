# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def helper(root):
            if not root:
                return (float('inf'), -float('inf'), True)
            leftMin, leftMax, leftValid = helper(root.left)
            rightMin, rightMax, rightValid = helper(root.right)
            myMin = min(leftMin, rightMin, root.val)
            myMax = max(leftMax, rightMax, root.val)
            myValid = leftMax < root.val and root.val < rightMin and leftValid and rightValid
            return (myMin, myMax, myValid)
        return helper(root)[2]