# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head

        def getMid(head):
            fast = head
            slow = None
            while fast and fast.next:
                fast = fast.next.next
                slow = head if slow == None else slow.next
            ret = slow.next
            slow.next = None
            return ret
            # 1, 2, 3

        def merge(left, right):
            dummy = ListNode()
            p1 = left
            p2 = right
            p = dummy
            while p1 and p2:
                if p1.val <= p2.val:
                    p.next = p1
                    p1 = p1.next
                else:
                    p.next = p2
                    p2 = p2.next
                p = p.next
            p.next = p1 if p1 else p2
            return dummy.next

        mid = getMid(head)
        left = self.sortList(head)
        right = self.sortList(mid)
        return merge(left, right)