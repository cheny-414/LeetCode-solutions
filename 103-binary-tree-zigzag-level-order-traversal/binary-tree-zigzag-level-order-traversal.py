# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        if not root:
            return res
        q = deque([root])
        level = 0
        while q:
            size = len(q)
            currLevel = []
            for i in range(size):
                curr = q.popleft()
                currLevel.append(curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            res.append(currLevel)
            if level % 2 == 1:
                currLevel.reverse()
            level += 1
        return res