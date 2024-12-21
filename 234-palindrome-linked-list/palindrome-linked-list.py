# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        def reverse(node):
            if not node:
                return None
            prev = None
            p = node
            while p:
                temp = p.next
                p.next = prev
                prev = p
                p = temp
            return prev
        if not head or not head.next:
            return True
        if not head.next.next:
            return head.val == head.next.val
        fast = head
        slow = head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        if fast:
            slow = slow.next
        second = reverse(slow)
        first = head
        while first and second:
            if first.val != second.val:
                return False
            first = first.next
            second = second.next
        return True
            