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

    public boolean isBalanced(TreeNode root) {
        
        // 1 = balanced
        return dfs(root)[0] == 1;
    }

    public int[] dfs(TreeNode root) {
        // [0] represents balanced --> 0 if false, 1 if true
        // [1] represents height of tree
        if (root == null) {
            return new int[] {1, 0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        // checks if balanced if left subtree is balanced, right subtree is balanced,
        // and if the height diff between the subtrees is at most 1
        boolean balanced = (left[0] == 1 && right[0] == 1) &&
                            (Math.abs(left[1] - right[1]) <= 1);
        
        int height = 1 + Math.max(left[1], right[1]);

        return new int[] {balanced ? 1 : 0, height};
    }

}
