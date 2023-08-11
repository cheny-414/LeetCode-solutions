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
    public List<Integer> preorderTraversal(TreeNode root) {
        BSTIterator it = new BSTIterator(root);
        List<Integer> result = new ArrayList<>();
        while (it.hasNext()) {
            result.add(it.next());
        }
        return result;
    }
}

class BSTIterator {
    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode curr = root;
        if (curr != null) {
            stack.push(curr);
        }
    }
    
    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            stack.push(node.right);
        } 
        if (node.left != null) {
            stack.push(node.left);
        }

        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}