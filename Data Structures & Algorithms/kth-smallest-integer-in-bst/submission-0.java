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

    List<Integer> list = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        
        // inorder traversal
        traverseInOrder(root);
        System.out.println(list);
        return list.get(k - 1);
    }

    public void traverseInOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        traverseInOrder(root.left);

        list.add(root.val);

        traverseInOrder(root.right);
    }
}
