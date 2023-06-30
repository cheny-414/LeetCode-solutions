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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode p = head;
        int n = 1;

        while (p.next != null) {
            p = p.next;
            n++;
        }
        p.next = head;
        k = k % n;

        for (int i = 0; i < n - k; i++) {
            p = p.next;
        }
        ListNode temp = p.next;
        p.next = null;
        return temp;
    }
}