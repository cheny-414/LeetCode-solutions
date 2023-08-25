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
    Map<Integer, List<Integer>> graph = new HashMap<>();
    public int amountOfTime(TreeNode root, int start) {
        createGraph(root);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        int time = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                visited.add(curr);
                for (int neighbor : graph.get(curr)) {
                    if (visited.contains(neighbor)) continue;
                    q.add(neighbor);
                }
            }
            time++;
        }
        return time;
    }

    private void createGraph(TreeNode root) {
        graph.putIfAbsent(root.val, new ArrayList<>());
        if (root.left != null) {
            graph.get(root.val).add(root.left.val);
            graph.putIfAbsent(root.left.val, new ArrayList<>());
            graph.get(root.left.val).add(root.val);
            createGraph(root.left);
        }
        if (root.right != null) {
            graph.get(root.val).add(root.right.val);
            graph.putIfAbsent(root.right.val, new ArrayList<>());
            graph.get(root.right.val).add(root.val);
            createGraph(root.right);
        }
    }
}