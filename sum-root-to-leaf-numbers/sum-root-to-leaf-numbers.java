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
    int globalSum = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return this.globalSum;
    }

    private void dfs(TreeNode root, int sumSoFar) {
        int sum = root.val + sumSoFar * 10;
        if (root.left == null && root.right == null) {
            globalSum += sum;
            return;
        }

        if (root.left != null) {
            dfs(root.left, sum);
        }
        if (root.right != null) {
            dfs(root.right, sum);
        }

    }
}