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
    public List<List<Integer>> levelOrder(TreeNode root) {

        // level-order traversal = bfs approach
        List<List<Integer>> lists = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            // add each level to list
            List<Integer> list = new ArrayList<>();

            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (node != null) {
                    list.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }

            if (list.size() > 0) {
                lists.add(list);
            }

        }

        return lists;
    }

}
