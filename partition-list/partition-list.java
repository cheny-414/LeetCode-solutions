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
    public ListNode partition(ListNode head, int x) {
        ListNode prehead = new ListNode(0, head);
        ListNode less = new ListNode();
        ListNode lessHead = less;
        ListNode more = new ListNode();
        ListNode moreHead = more;
        ListNode curr = head;;
        while (curr != null) {
            if (curr.val < x) {
                less.next = curr;
                less = less.next;
            } else {
                more.next = curr;
                more = more.next;
            }
            curr = curr.next;
        }
        more.next = null;
        less.next = moreHead.next;
        return lessHead.next;
    }
}