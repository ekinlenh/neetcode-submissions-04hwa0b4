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
        
        if (root.val == p.val || root.val == q.val) {
            // check if p or q is a descendant of the other

            if (root.left != null) {            
                if (root.left.val == q.val) {
                    return p;
                }

                if (root.left.val == p.val) {
                    return q;
                }
            }

            if (root.right != null) {
                if (root.right.val == q.val) {
                    return p;
                }

                if (root.right.val == p.val) {
                    return q;
                } 
            }

            
        }

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
