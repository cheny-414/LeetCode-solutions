# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def distanceK(self, root: TreeNode, target: TreeNode, k: int) -> List[int]:
        adj = defaultdict(list)
        def buildGraph(root):
            if not root:
                return
            if root.left:
                adj[root.left.val].append(root.val)
                adj[root.val].append(root.left.val)
            if root.right:
                adj[root.right.val].append(root.val)
                adj[root.val].append(root.right.val)
            buildGraph(root.left)
            buildGraph(root.right)
        buildGraph(root)
        q = deque([target.val])
        distance = 0
        visited = set()
        visited.add(target.val)
        while q:
            if distance == k:
                return list(q)
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                for nei in adj[curr]:
                    if nei not in visited:
                        q.append(nei)
                        visited.add(nei)
            distance += 1
        return []