/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    Map<Integer, List<String>> map = new HashMap<>();
    int maxLevels;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        maxLevels = 0;
        writeNode(root, 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= maxLevels; i++) {
            for (String value : map.get(i)) {
                sb.append(value);
                sb.append(",");
            }
        }
        String result = sb.toString();
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        if (values.length == 1) return null;

        Deque<TreeNode> q = new ArrayDeque<>();
        TreeNode treeRoot = new TreeNode(Integer.valueOf(values[0]));
        q.add(treeRoot);
        int i = 1;

        while (i < values.length) {
            String leftVal = values[i++];
            String rightVal = values[i++];
            TreeNode root = q.poll();
            if (!leftVal.equals("null")) {
                TreeNode leftNode = new TreeNode(Integer.valueOf(leftVal));
                root.left = leftNode;
                q.add(leftNode);
            }
            if (!rightVal.equals("null")) {
                TreeNode rightNode = new TreeNode(Integer.valueOf(rightVal));
                root.right = rightNode;
                q.add(rightNode);
            }
        }
        return treeRoot;
    }
    private void writeNode(TreeNode root, int level) {
        maxLevels = Math.max(maxLevels, level);
        if (!map.containsKey(level)) {
            map.put(level, new ArrayList<String>());
        }
        if (root == null) {
            map.get(level).add("null");
            return;
        }
        map.get(level).add(String.valueOf(root.val));
        writeNode(root.left, level + 1);
        writeNode(root.right, level + 1);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));