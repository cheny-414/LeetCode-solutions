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
    int max = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root.left, 'r', 'l', 0);
        dfs(root.right, 'l', 'r', 0);
        return max;
    }

    private void dfs(TreeNode root, char lastDir, char dir, int length) {
        if (root == null) {
            return;
        }

        if (lastDir == dir) {
            length = 1;
        }
        else {
            length++;
        }

        if (length > max) {
            max = length;
        }
        dfs(root.left, dir, 'l', length);
        dfs(root.right, dir, 'r', length);
    }
}