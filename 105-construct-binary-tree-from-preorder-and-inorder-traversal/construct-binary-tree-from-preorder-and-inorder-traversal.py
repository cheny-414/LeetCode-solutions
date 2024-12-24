# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        def helper(inLeft, inRight, preLeft, preRight):
            if inLeft > inRight or preLeft > preRight:
                return None
            parent = preorder[preLeft]
            parentIndex = inorder.index(parent, inLeft, inRight + 1)
            leftChildSize = parentIndex - inLeft
            rightChildSize = inRight - parentIndex
            leftChild = helper(inLeft, parentIndex - 1, preLeft + 1, preLeft + leftChildSize)
            rightChild = helper(parentIndex + 1, inRight, preLeft + leftChildSize + 1, preRight)
            node = TreeNode(parent, leftChild, rightChild)
            return node
        return helper(0, len(inorder) - 1, 0, len(preorder) - 1)