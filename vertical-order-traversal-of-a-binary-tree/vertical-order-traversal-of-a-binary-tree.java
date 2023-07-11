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
    Map<Integer, PriorityQueue<int[]>> map;
    int minCol = Integer.MAX_VALUE;
    int maxCol = Integer.MIN_VALUE;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new HashMap<>();
        dfs(root, 0, 0);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = minCol; i <= maxCol; i++) {
            List<Integer> col = new ArrayList<>();
            while (!map.get(i).isEmpty()) {
                col.add(map.get(i).poll()[1]);
            }
            result.add(col);
        }
        return result;
    }

    private void dfs(TreeNode root, int row, int col) {
        if (root == null) return;
        minCol = Math.min(minCol, col);
        maxCol = Math.max(maxCol, col);
        if (!map.containsKey(col)) {
            //row, value
            map.put(col, new PriorityQueue<int[]>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        }
        map.get(col).add(new int[] {row, root.val});
        dfs(root.left, row + 1, col - 1);
        dfs(root.right, row + 1, col + 1);
    }
}