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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode pointer = l3;
        boolean carry = false;
        while (l1 != null || l2 != null || carry) {
            int sum = 0;
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val + (carry ? 1 : 0);
            } else if (l1 != null) {
                sum = l1.val + (carry ? 1 : 0);
            } else if (l2 != null){
                sum = l2.val + (carry ? 1 : 0);
            } else {
                sum = carry ? 1 : 0;
            }
            if (sum >= 10) {
                sum -= 10;
                carry = true;
            } else {
                carry = false;
            }
            pointer.next = new ListNode(sum);
            pointer = pointer.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return l3.next;
    }
}