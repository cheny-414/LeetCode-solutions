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
    Map<Integer, TreeNode> map = new HashMap<>();
    Map<TreeNode, Pair<TreeNode, Boolean>> parents = new HashMap<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<TreeNode> set = new HashSet<>();
        set.add(root);
        dfs(root, null, false);
        for (int i = 0; i < to_delete.length; i++) {
            TreeNode del = map.get(to_delete[i]);
            if (set.contains(del)) {
                set.remove(del);
            }
            if (del.left != null) {
                set.add(del.left);
            }
            if (del.right != null) {
                set.add(del.right);
            }
            TreeNode parent = parents.get(del).getKey();
            boolean left = parents.get(del).getValue();
            if (parent != null) {
                if (left) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        }
        List<TreeNode> answer = new ArrayList<TreeNode>(set);
        return answer;
    }

    private void dfs(TreeNode root, TreeNode parent, boolean left) {
        if (root == null) return;
        map.put(root.val, root);
        parents.put(root, new Pair<>(parent, left));
        dfs(root.left, root, true);
        dfs(root.right, root, false);
    }
}