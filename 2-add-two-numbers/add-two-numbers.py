# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: Optional[ListNode]
        :type l2: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        carry = 0
        head = ListNode()
        pointer = head
        while l1 != None and l2 != None:
            sum = l1.val + l2.val + carry
            if sum > 9:
                sum -= 10
                carry = 1
            else:
                carry = 0
            node = ListNode(val = sum)
            pointer.next = node
            pointer = pointer.next
            l1 = l1.next
            l2 = l2.next
        while l1 != None:
            sum = l1.val + carry
            if sum > 9:
                sum -= 10
                carry = 1
            else:
                carry = 0
            node = ListNode(val = sum)
            pointer.next = node
            pointer = pointer.next
            l1 = l1.next
        while l2 != None:
            sum = l2.val + carry
            if sum > 9:
                sum -= 10
                carry = 1
            else:
                carry = 0
            node = ListNode(val = sum)
            pointer.next = node
            pointer = pointer.next
            l2 = l2.next
        if carry == 1:
            node = ListNode(val = 1)
            pointer.next = node
        return head.next

            
        