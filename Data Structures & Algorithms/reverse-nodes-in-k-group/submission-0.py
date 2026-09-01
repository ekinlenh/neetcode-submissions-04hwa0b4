# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head or not head.next:
            return head

        size = 0
        curr = head
        while curr:
            curr = curr.next
            size += 1
        
        dummy = ListNode(-1)
        dummy.next = head

        prev = dummy
        first = None
        second = head
        for _ in range(size // k):
            prev_group = second
            i = 0
            # reverse this group
            while i < k and second:
                temp = second.next
                second.next = first
                first = second
                second = temp
                i += 1
            
            # go to next group
            prev.next = first
            prev_group.next = second
            prev = prev_group
            first = None
        
        return dummy.next

        # [1, 2, 3, 4, 5, 6] k = 3
        # size = 6, dummy.next -> Node(1)
        # prev = dummy, first = None, second = Node(1)
        # for _ in range(2): runs twice
        # prev_group = Node(1), i = 0
        # while i < k (i = 0) and second:
        # temp = Node(2), second.next = None, first = Node(1), second = Node(2), i = 1
        # temp = Node(3), second.next = Node(1), first = Node(2), second = Node(3), i = 2
        # temp = Node(4), second.next = Node(2), first = Node(3), second = Node(4), i = 3
        # prev = Node(1)
        # prev.next = Node(4)
        # first = none