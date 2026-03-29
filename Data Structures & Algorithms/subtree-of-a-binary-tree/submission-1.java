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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // idea: go through root until locating the subRoot
        // then check with dfs / bfs if they match and return true 
        if (root == null && subRoot == null) {
            return true;
        } 

        if ((root == null && subRoot != null) || (root != null && subRoot == null)) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.val == subRoot.val && checkIfSame(node, subRoot)) {
                return true;

            } else {
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return false;
    }

    public boolean checkIfSame(TreeNode node1, TreeNode node2) {

        if (node1 == null && node2 == null) {
            return true;
        }

        if ((node1 == null && node2 != null) || (node1 != null && node2 == null)) {
            return false;
        }

        if (node1.val == node2.val) {
            return checkIfSame(node1.left, node2.left) && checkIfSame(node1.right, node2.right);
        } else {
            return false;
        }
    }

}
