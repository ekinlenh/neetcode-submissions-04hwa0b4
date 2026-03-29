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
    public void reorderList(ListNode head) {
        // Time-Complexity: O(n)
        // Space-Complexity: O(1)

        // we want to split the list into two halves
        // and then reverse the second half of the list 

        // first we use two-pointers to reach second half
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // then we want to reverse the list
        ListNode second = slow.next; // slow.next is the beginning of the second half
        ListNode prev = slow.next = null; // null to separate the two halves of the list
        while (second != null) {
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next; 
        }

        // now we merge both halves of the list
        ListNode first = head;
        second = prev; // prev is the beginning of the second half list
        while (second != null) {
            ListNode temp1 = first.next, temp2 = second.next; 
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }
}
