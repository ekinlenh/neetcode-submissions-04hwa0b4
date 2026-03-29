/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // we can take it a step further by putting the node vals into a list and sorting
        // better time complexity, but more memory usage
        // Time Complexity: O(n*logn)
        // Space Complexity: O(n)

        List<Integer> nodeVals = new ArrayList<>();
        for (ListNode node: lists) {
            while (node != null) {
                nodeVals.add(node.val);
                node = node.next;
            }
        }
        Collections.sort(nodeVals);

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        for (int node: nodeVals) {
            current.next = new ListNode(node);
            current = current.next;
        }

        return dummy.next;
    }
}
