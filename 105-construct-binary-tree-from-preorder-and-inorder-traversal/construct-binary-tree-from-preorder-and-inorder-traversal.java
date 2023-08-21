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
    int[] preorder;
    int[] inorder;
    Map<Integer, Integer> inorderIndexMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return helper(0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode helper(int preStart, int preEnd, int inStart, int inEnd) {
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        if (preEnd == preStart) return root;
        int index = inorderIndexMap.get(rootVal);
        
        //left side:
        int preStartL = preStart + 1;
        int inStartL = inStart;
        int inEndL = index - 1;
        int preEndL = preStart + (inEndL - inStartL + 1);

        //right side:
        int preStartR = preEndL + 1;
        int preEndR = preEnd;
        int inStartR = index + 1;
        int inEndR = inEnd;
        
        
        root.left = (preStartL <= preEndL) ? helper(preStartL, preEndL, inStartL, inEndL) : null;
        root.right = (preStartR <= preEndR) ? helper(preStartR, preEndR, inStartR, inEndR): null;
        return root;
    }
}

// start --> end (preorder), start2 --> end2 inorder
// root = preorder[start];
// index = inorderIndexMap.get(root);
// PRE: left = start + 1 --> (lenL), point -> end
// IN : left = start2 --> index - 1 (lenL), right = index + 1 --> end2 (lenR)