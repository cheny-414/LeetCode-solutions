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
    public void reorderList(ListNode head) {
        //1. find middle node
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //2. reverse second half of list
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        //3. merge 2 sorted lists
        ListNode prehead = new ListNode();
        ListNode pointer = prehead;
        ListNode list1 = head;
        ListNode list2 = prev;
        while (list1 != null && list2 != null) {
            ListNode temp = list1.next;
            ListNode temp2 = list2.next;
            list1.next = list2;
            list2.next = temp;
            list1 = temp;
            list2 = temp2;
        }
        //return prehead.next;
    }
}