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
    int count = 0;
    int k = 0;
    int kth = Integer.MAX_VALUE;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return kth;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        count++;
        if (count == k) {
            kth = node.val;
            return;
        }
        inorder(node.right);
    }
}