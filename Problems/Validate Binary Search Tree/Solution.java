/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        return helper(root.left, Long.MIN_VALUE, root.val) && 
               helper(root.right, root.val, Long.MAX_VALUE);
    }
    private boolean helper(TreeNode root, long minVal, long maxVal) {
        if (root == null) {
            return true;
        }
        if (root.val >= maxVal) {
            return false;
        }
        if (root.val <= minVal) {
            return false;
        }
        return helper(root.left, minVal, root.val) && helper(root.right, root.val, maxVal);
    }
}