# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        if not head: return None
        sentinel = ListNode(0, head)
        behind = sentinel
        ahead = head
        while ahead:
            if ahead.val != val:
                behind.next = ahead
                behind = behind.next
            ahead = ahead.next
        behind.next = None
        return sentinel.next
                