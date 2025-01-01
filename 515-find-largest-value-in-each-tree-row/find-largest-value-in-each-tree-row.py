# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        q = deque([root])
        ans = []
        if not root:
            return ans
        level = 0
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if len(ans) == level:
                    ans.append(curr.val)
                else:
                    ans[-1] = max(ans[-1], curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            level += 1
        return ans