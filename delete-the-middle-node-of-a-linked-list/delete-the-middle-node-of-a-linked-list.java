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
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }
        ListNode p1 = head, p2 = head;
        int count = 1;
        while (p1.next != null) {
            p1 = p1.next;
            count++;
        }

        int mid = count / 2;

        for (int i = 0; i < mid - 1; i++) {
            p2 = p2.next;
        }

        p2.next = p2.next.next;
        return head;
    }
}