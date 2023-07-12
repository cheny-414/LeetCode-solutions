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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            result = merge2Lists(result, lists[i]);
        }
        return result;
    }
    
    private ListNode merge2Lists(ListNode first, ListNode second) {
        ListNode prehead = new ListNode();
        ListNode curr = prehead;
        ListNode firstP = first;
        ListNode secondP = second;

        while (firstP != null && secondP != null) {
            if (firstP.val < secondP.val) {
                curr.next = firstP;
                firstP = firstP.next;
            } else {
                curr.next = secondP;
                secondP = secondP.next;
            }
            curr = curr.next;
        }
        while (secondP != null) {
            curr.next = secondP;
            curr = curr.next;
            secondP = secondP.next;
        }
        while (firstP != null) {
            curr.next = firstP;
            curr = curr.next;
            firstP = firstP.next;
        }
        return prehead.next;
    }
}