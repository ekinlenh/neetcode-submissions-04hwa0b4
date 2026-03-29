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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        int[] preIndex = {0};
        return buildTreeRecur(inorder, preorder, preIndex, 0, preorder.length - 1);
    }

    public TreeNode buildTreeRecur(int[] inorder, int[] preorder, int[] preIndex, int left, int right) {

        if (left > right) {
            return null;
        }

        int rootVal = preorder[preIndex[0]];
        preIndex[0]++;

        TreeNode root = new TreeNode(rootVal);
        int index = search(inorder, rootVal, left, right);

        root.left = buildTreeRecur(inorder, preorder, preIndex, left, index - 1);
        root.right = buildTreeRecur(inorder, preorder, preIndex, index + 1, right);

        return root;
    }

    public int search(int[] inorder, int value, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (inorder[i] == value)
                return i;
        }
        return -1;
    }
}
