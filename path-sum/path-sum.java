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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }

    private boolean dfs(TreeNode node, int sumSoFar, int targetSum) {
        if (node == null) return false;
        if (node.val + sumSoFar == targetSum && node.left == null && node.right == null) return true;
        return (dfs(node.left, node.val + sumSoFar, targetSum) || dfs(node.right, node.val + sumSoFar, targetSum));
    }
}