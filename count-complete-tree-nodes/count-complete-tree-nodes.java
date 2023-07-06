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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        TreeNode node = root;
        int height = -1;
        while (node != null) {
            node = node.left;
            height++;
        }

        if (height == 0) return 1;

        int left = 1;
        int right = (int)Math.pow(2, height) - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (exists(mid, height, root)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int)Math.pow(2, height) - 1 + left;
    }

    private boolean exists(int index, int height, TreeNode node) {
        int left = 0;
        int right = (int)Math.pow(2, height) - 1;
        for (int i = 0; i < height; i++) {
            int mid = left + (right - left) / 2;
            if (index <= mid) {
                node = node.left;
                right = mid;
            } else {
                node = node.right;
                left = mid + 1;
            }
        }
        return node != null;
    }
}