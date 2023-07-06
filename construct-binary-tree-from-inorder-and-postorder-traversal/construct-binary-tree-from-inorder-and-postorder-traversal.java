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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildHelper(inorder, postorder);
    }

    private TreeNode buildHelper(int[] inorder, int[] postorder) {
        int rootVal = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootVal);
        int index = findIndex(inorder, rootVal);
        if (index > 0) {
            root.left = buildHelper(Arrays.copyOfRange(inorder, 0, index), Arrays.copyOfRange(postorder, 0, index));
        } else {
            root.left = null;
        }

        if (index < inorder.length - 1) {
            root.right = buildHelper(Arrays.copyOfRange(inorder, index + 1, inorder.length), Arrays.copyOfRange(postorder, index, postorder.length - 1));
        } else {
            root.right = null;
        }

        return root;
    }

    public static int findIndex(int arr[], int t)
    {
  
        // if array is Null
        if (arr == null) {
            return -1;
        }
  
        // find length of array
        int len = arr.length;
        int i = 0;
  
        // traverse in the array
        while (i < len) {
  
            // if the i-th element is t
            // then return the index
            if (arr[i] == t) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }
}