# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        sentinel = ListNode()
        ret = sentinel
        curr = head
        while curr and curr.next:
            if curr.val == curr.next.val:
                val = curr.val
                while curr and curr.val == val:
                    curr = curr.next
            else:
                sentinel.next = curr
                sentinel = sentinel.next
                curr = curr.next
        if curr:
            sentinel.next = curr
        else:
            sentinel.next = None
        return ret.next