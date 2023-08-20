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
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        ListNode headP = new ListNode();
        headP.next = head;
        ListNode curr = head;
        ListNode p = headP;
        
        while (curr.next != null) {
            if (curr.next.val > curr.val) {
                curr = curr.next;
            } else {
                while (p.next.val < curr.next.val) {
                    p = p.next;
                }
                ListNode temp = curr.next.next;
                curr.next.next = p.next;
                p.next = curr.next;
                curr.next = temp;
                p = headP;
            }
        }
        return headP.next;
    }
}