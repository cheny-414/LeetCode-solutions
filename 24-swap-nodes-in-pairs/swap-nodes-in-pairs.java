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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curr = head;
        ListNode next = head.next;
        ListNode rest = next.next;
        next.next = curr;
        if (rest != null) {
            curr.next = swapPairs(rest);
        } else {
            curr.next = null;
        }
        return next;
    }
}