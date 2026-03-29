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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // case 1: q is in p subtree or vice versa: return p/q
        // case 2: different subtrees, return parent node
        if (root == null || p == null || q == null) {
            return null;
        }

        if (Math.max(p.val, q.val) < root.val) {
            // search left of root node 
            return lowestCommonAncestor(root.left, p, q);
        } else if (Math.min(p.val, q.val) > root.val) {
            // search right of root node
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
