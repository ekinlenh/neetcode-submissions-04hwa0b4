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
        // for loop through lists, while loop for nodes inside the lists
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        
        ListNode curr = dummy;
        for (ListNode node: lists) {
            while (node != null) {
                curr.next = node;
                curr = curr.next;
                node = node.next;
            }
        }

        curr = dummy;
        while (curr != null) {
            ListNode index = curr.next;
            ListNode min = curr;

            while (index != null) {
                if (index.val < min.val) {
                    min = index;
                }
                index = index.next;
            }

            int temp = curr.val;
            curr.val = min.val;
            min.val = temp;
            curr = curr.next;
        }
        

        return dummy.next;
    }
}
