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
    public List<Double> averageOfLevels(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        long sum = 0L;
        int count = 0;
        List<Double> ans = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                count++;
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            ans.add(sum * 1.0 / count);
            sum = 0;
            count = 0;
        }
        return ans;
    }
}