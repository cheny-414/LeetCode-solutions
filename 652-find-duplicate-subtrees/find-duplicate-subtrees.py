# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findDuplicateSubtrees(self, root: Optional[TreeNode]) -> List[Optional[TreeNode]]:
        def explore(root):
            if not root: return 0
            triplet = (explore(root.left), root.val, explore(root.right))
            if triplet not in triplet_dict:
                triplet_dict[triplet] = len(triplet_dict) + 1
            id = triplet_dict[triplet]
            cnt[id] += 1
            if cnt[id] == 2:
                ans.append(root)
            return id
        triplet_dict = {}
        cnt = defaultdict(int)
        ans = []
        explore(root)
        return ans
