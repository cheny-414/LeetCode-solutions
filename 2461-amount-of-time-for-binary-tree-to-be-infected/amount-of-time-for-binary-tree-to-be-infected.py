# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def amountOfTime(self, root: Optional[TreeNode], start: int) -> int:
        nodeToParent = defaultdict()
        q = deque()
        visited = set()
        def dfs(root):
            if not root:
                return
            if start == root.val:
                q.append(root)
                visited.add(root)
            if root.left:
                nodeToParent[root.left] = root
            if root.right:
                nodeToParent[root.right] = root
            dfs(root.left)
            dfs(root.right)
        dfs(root)
        days = 0
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                parent = nodeToParent[curr] if curr in nodeToParent else None
                if parent and parent not in visited:
                    q.append(parent)
                    visited.add(parent)
                if curr.left and curr.left not in visited:
                    q.append(curr.left)
                    visited.add(curr.left)
                if curr.right and curr.right not in visited:
                    q.append(curr.right)
                    visited.add(curr.right)
            days += 1
        return days - 1
                