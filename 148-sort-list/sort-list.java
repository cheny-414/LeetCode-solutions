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

    //merge sort
    public ListNode sortList(ListNode head) {
        //base case
        if (head == null || head.next == null) return head;

        //split list in two
        ListNode mid = getMid(head);
        ListNode temp = mid.next;
        mid.next = null;

        //sort each half
        ListNode left = sortList(head);
        ListNode right = sortList(temp);

        //merge 2 halves
        return merge(left, right);
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode prehead = new ListNode();
        ListNode p = prehead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        if (left != null) {
            p.next = left;
        }
        if (right != null) {
            p.next = right;
        }
        return prehead.next;
    }
}