/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
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
    
    private ListNode reverse(ListNode head, ListNode next) {
        ListNode newHead = next;   
        if(next.next != null) {
            newHead = reverse(next, next.next);
        }
        head.next = null;
        next.next = head;
        return newHead;
    }
    
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        return reverse(head,head.next);    
    }
}
