# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def dfs(root, p, q):
            pFound = False
            qFound = False
            if not root:
                return (False, False, None)
            if root.val == p.val:
                pFound = True
            elif root.val == q.val:
                qFound = True
            pFound1, qFound1, foundNode1 = dfs(root.left, p, q)
            pFound2, qFound2, foundNode2 = dfs(root.right, p, q)
            if foundNode1:
                return (True, True, foundNode1)
            if foundNode2:
                return (True, True, foundNode2)
            pFound = pFound or pFound1 or pFound2
            qFound = qFound or qFound1 or qFound2
            if pFound and qFound:
                return (True, True, root)
            else:
                return (pFound, qFound, None)
        return dfs(root, p, q)[2]