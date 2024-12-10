# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return None
        if not head.next:
            return head
        odd = head
        even = head.next
        even_start = even
        while even and even.next:
            odd.next = even.next
            odd = odd.next
            #prev_even = even
            even.next = odd.next
            even = even.next
        odd.next = even_start
        return head
