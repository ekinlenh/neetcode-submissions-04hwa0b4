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
    public boolean hasCycle(ListNode head) {
        // we can use two-pointers that travel as different speeds
        // eventually, the pointers will meet (if there is a cycle)

        // checks for if linked list has only one node
        if (head.next == null) {
            return false;
        }

        ListNode pointerOne = head, pointerTwo = head;

        while (pointerTwo != null) {
            pointerOne = pointerOne.next;
            pointerTwo = pointerTwo.next.next;
            
            if (pointerOne == pointerTwo) {
                return true;
            }

        }

        return false;
    }
}
