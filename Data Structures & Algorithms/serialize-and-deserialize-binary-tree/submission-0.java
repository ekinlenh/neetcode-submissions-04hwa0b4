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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();

        // do bfs approach (each depth, add node val or "." if null)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                    s.append(node.val + ",");
                } else {
                    s.append("null,");
                }
            }
        }

        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }

        String[] values = data.split(",");
        if (values[0].equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < data.length()) {
            TreeNode curr = queue.poll();
            if (i < data.length()) {
                if (values[i].equals("null")) {
                    curr.left = null;
                } else {
                    TreeNode leftChild = new TreeNode(Integer.parseInt(values[i]));
                    curr.left = leftChild;
                    queue.offer(leftChild);
                }
                i++;
            }

            if (i < data.length()) {
                if (values[i].equals("null")) {
                    curr.right = null;
                } else {
                    TreeNode rightChild = new TreeNode(Integer.parseInt(values[i]));
                    curr.right = rightChild;
                    queue.offer(rightChild);
                }
                i++;
            }
        }

        return root;
    
    }
}
