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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // first idea: go through linkedlist and get size
        // now we can loop through list.size() - n to reach the nth node
        // and we can set a prev pointer to current.next pointer

        // account for empty and single linked lists
        if (head == null || head.next == null) {
            return null;
        }

        ListNode current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }

        // must account for length = n (beginning of linked list)
        if (length == n) {
            head = head.next;
        } else {
            ListNode prev = null;
            current = head;
            for (int i = 0; i < length - n; i++) {
                prev = current;
                current = current.next;
            }
            prev.next = current.next;
        }

        return head;
    }
}
