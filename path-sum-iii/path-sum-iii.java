/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int target;
    int count = 0;
    HashMap<Long, Integer> map = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        dfs(root, 0);
        return count;
    }

    private void dfs(TreeNode node, long sumSoFar) {
        if (node == null) {
            return;
        }
        sumSoFar += node.val;
        if (sumSoFar == target) {
            count++;
        }
        count += map.getOrDefault(sumSoFar - target, 0);

        map.put(sumSoFar, map.getOrDefault(sumSoFar, 0) + 1);

        dfs(node.left, sumSoFar);
        dfs(node.right, sumSoFar);

        map.put(sumSoFar, map.get(sumSoFar) - 1);
    }
}