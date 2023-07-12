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
        if (lists.length == 1) return lists[0];
        if (lists.length == 2) return merge2Lists(lists[0], lists[1]);
        return merge2Lists(mergeKLists(Arrays.copyOfRange(lists, 0, lists.length / 2)), 
            mergeKLists(Arrays.copyOfRange(lists, lists.length / 2, lists.length)));
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