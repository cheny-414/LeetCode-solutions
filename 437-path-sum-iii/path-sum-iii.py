# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        prefix_sum = {}
        prefix_sum[0] = 1
        count = 0
        def explore(root, sum_so_far):
            nonlocal count
            if not root: return 0
            sum_so_far += root.val
            target = sum_so_far - targetSum
            if target in prefix_sum.keys():
                count += prefix_sum[target]
            if sum_so_far in prefix_sum:
                prefix_sum[sum_so_far] += 1
            else:
                prefix_sum[sum_so_far] = 1
            explore(root.left, sum_so_far)
            explore(root.right, sum_so_far)
            prefix_sum[sum_so_far] -= 1
        explore(root, 0)
        return count