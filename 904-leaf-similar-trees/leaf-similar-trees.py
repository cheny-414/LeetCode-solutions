# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def leafSimilar(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
        leaves1 = []
        leaves2 = []
        def getLeaves(node, rootnum):
            if not node.left and not node.right:
                if rootnum == 1:
                    leaves1.append(node.val)
                else:
                    leaves2.append(node.val)
            if node.left:
                getLeaves(node.left, rootnum)
            if node.right:
                getLeaves(node.right, rootnum)
        getLeaves(root1, 1)
        getLeaves(root2, 2)
        return leaves1 == leaves2