/**
* Given the head of a linked list, remove the nth node from the end of the list and return its head.
*
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        int count = 0;
        while(p1 != null) {
            if(count++ > n) p2 = p2.next;
            p1 = p1.next;
        }
        if(count == n) return head.next;
        p2.next = p2.next.next;
        return head;
    }
}
