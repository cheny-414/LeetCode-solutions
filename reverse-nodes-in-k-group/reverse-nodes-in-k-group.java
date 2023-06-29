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
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode ptr = head;

        while (count < k && ptr != null) {
            ptr = ptr.next;
            count++;
        }

        if (count == k) {
            ListNode reversedHead = this.reverseLinkedList(head, k);
            head.next = reverseKGroup(ptr, k);
            return reversedHead;
        } else {
            return head;
        }
    }

    private ListNode reverseLinkedList(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        while (k > 0) {
            ListNode third = curr.next;
            curr.next = prev;
            prev = curr;
            curr = third;
            k--;
        }
        return prev;
    }
}