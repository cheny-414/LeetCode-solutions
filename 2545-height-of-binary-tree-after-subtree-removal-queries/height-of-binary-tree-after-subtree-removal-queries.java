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
    TreeNode root;
    HashMap<Integer, PriorityQueue<Pair<Integer, Integer>>> map; //level, pq(pair: node.val, depth)
    HashMap<Integer, Integer> levels; //node.val, level
    public int[] treeQueries(TreeNode root, int[] queries) {
        this.root = root;
        map = new HashMap<>();
        levels = new HashMap<>();
        int[] answer = new int[queries.length];
        int maxLevel = dfs(root, 0) - 1;
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            int level = levels.get(query);
            if (map.get(level).peek().getKey() == query) {
                Pair<Integer, Integer> popped = map.get(level).poll();
                if (map.get(level).size() == 0) {
                    answer[i] = maxLevel - popped.getValue();
                } else {
                    answer[i] = maxLevel - popped.getValue() + map.get(level).peek().getValue();
                }
                map.get(level).add(popped);
            } else {
                answer[i] = maxLevel;
            }
        }
        return answer;
    }

    private int dfs(TreeNode root, int level) {
        if (root == null) return 0;
        levels.put(root.val, level);

        if (!map.containsKey(level)) {
            map.put(level, new PriorityQueue<Pair<Integer, Integer>>((a, b) -> b.getValue() - a.getValue()));
        }
        if (root.left == null && root.right == null) {
            map.get(level).add(new Pair<Integer, Integer>(root.val, 1));
            return 1;
        }
        int depth = 1 + Math.max(dfs(root.left, level + 1), dfs(root.right, level + 1));
        map.get(level).add(new Pair<Integer, Integer>(root.val, depth));
        return depth;
    }
}