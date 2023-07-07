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
    TreeNode prevNode;
    boolean isValid = true;
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return isValid;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        if (prevNode != null) {
            if (prevNode.val >= node.val) {
                isValid = false;
                return;
            }
        }
        prevNode = node;
        inorder(node.right);
    }
}