/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        var queue = new ArrayDeque<TreeNode[]>();
        queue.add(new TreeNode[] {original, cloned});
        while (!queue.isEmpty()) {
            TreeNode[] nodes = queue.poll();
            if (nodes[0] == target) return nodes[1];
            if (nodes[0].left != null) {
                queue.add(new TreeNode[] {nodes[0].left, nodes[1].left});
            }
            if (nodes[0].right != null) {
                queue.add(new TreeNode[] {nodes[0].right, nodes[1].right});
            }
        }
        return null;
    }
}