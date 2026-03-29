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
        // there are two halves of the linked list
        // we want to reverse the second half of the list
        // which we can get to buy using fast and slow pointers
        // where slow.next is the beginning of the second half of the linked list
        // afterward, we traverse both linked lists alternating 
        // and then point the last node to null 

        // fast and slow pointers to get to second half
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next; 
        }

        // now we reverse the linked list here
        ListNode second = slow.next;
        slow.next = null;
        ListNode prev = null; // this will become the head of the reversed linked list
        while (second != null) {
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next; 
        }

        // now we can reorder our list by merging both lists
        second = prev; 
        ListNode first = head;
        while (second != null) {
            ListNode temp1 = first.next, temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }

    }
}
