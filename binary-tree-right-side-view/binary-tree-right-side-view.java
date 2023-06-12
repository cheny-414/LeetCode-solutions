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
    HashMap<Integer, Integer> map = new HashMap<>();
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        if (root == null) return view;
        dfs(root, 0);
        int maxLevel = Collections.max(map.keySet());
        for (int i = 0; i <= maxLevel; i++) {
            view.add(map.get(i));
        }
        return view;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        
        map.put(level, root.val);
        level++;
        dfs(root.left, level);
        dfs(root.right, level);
    }
}