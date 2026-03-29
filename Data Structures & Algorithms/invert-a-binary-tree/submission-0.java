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
    public TreeNode invertTree(TreeNode root) {
        
        if (root != null) {
            invert(root);
        }

        return root;
    }

    public void invert(TreeNode root) {
        // use bfs
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            TreeNode tmp1 = null;
            TreeNode tmp2 = null;

            if (node.left != null) {
                queue.add(node.left);
                tmp1 = node.left;
            }

            if (node.right != null) {
                queue.add(node.right);
                tmp2 = node.right;
            }

            // invert code
            if (tmp1 != null || tmp2 != null) {
                node.left = tmp2;
                node.right = tmp1;
            }

        }
    }
}
