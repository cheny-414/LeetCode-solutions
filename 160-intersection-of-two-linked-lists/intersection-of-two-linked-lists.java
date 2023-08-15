/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        boolean aCycled = false;
        boolean bCycled = false;
        while (a != b) {
            if (a == null) {
                if (aCycled) return null;
                aCycled = true;
                a = headB;
            } else {
                a = a.next;
            }
            if (b == null) {
                if (bCycled) return null;
                bCycled = true;
                b = headA;
            } else {
                b = b.next;
            }
        }
        return a;
    }
}