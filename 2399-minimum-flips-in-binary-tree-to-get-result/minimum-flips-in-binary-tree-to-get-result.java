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
    Map<TreeNode, int[]> map = new HashMap<>();
    public int minimumFlips(TreeNode root, boolean result) {
        return result ? dfs(root)[1] : dfs(root)[0];
    }

    private int[] dfs(TreeNode root) {
        int[] res;
        if (map.containsKey(root)) {
            return map.get(root);
        }
        if (root.val == 0) {
            return res = new int[]{0, 1};
        } else if (root.val == 1) {
            return res = new int[] {1, 0};
        } else if (root.val == 5) {
            if (root.left != null) {
                res = dfs(root.left);
            } else {
                res = dfs(root.right);
            }
            int temp = res[0];
            res[0] = res[1];
            res[1] = temp;
            map.put(root, res);
            return res;
        }
        int l0r0 = dfs(root.left)[0] + dfs(root.right)[0];
        int l0r1 = dfs(root.left)[0] + dfs(root.right)[1];
        int l1r0 = dfs(root.left)[1] + dfs(root.right)[0];
        int l1r1 = dfs(root.left)[1] + dfs(root.right)[1];
        if (root.val == 2) {
            //OR
            int result0 = l0r0;
            int result1 = Math.min(Math.min(l0r1, l1r0), l1r1);
            res = new int[]{result0, result1};
            map.put(root, res);
            return res;
        }
        if (root.val == 3) {
            //AND
            int result0 = Math.min(Math.min(l0r0, l0r1), l1r0);
            int result1 = l1r1;
            res = new int[]{result0, result1};
            map.put(root, res);
            return res;
        }
        else {
            //XOR
            int result1 = Math.min(l1r0, l0r1);
            int result0 = Math.min(l0r0, l1r1);
            res = new int[]{result0, result1};
            map.put(root, res);
            return res;
        }
    }
}