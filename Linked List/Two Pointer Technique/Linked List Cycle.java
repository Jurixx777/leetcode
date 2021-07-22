/**
* Given head, the head of a linked list, determine if the linked list has a cycle in it.
* There is a cycle in a linked list if there is some node in the list that can be reached again by 
* continuously following the next pointer. Internally, pos is used to denote the index of the node 
* that tail's next pointer is connected to. Note that pos is not passed as a parameter.
* Return true if there is a cycle in the linked list. Otherwise, return false.
*
* class ListNode {
*     int val;
*     ListNode next;
*     ListNode(int x) {
*         val = x;
*         next = null;
*     }
* }
*/

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode n1 = head;
        ListNode n2 = head;
        while(n1 != n2.next){
            n1 = n1.next;
            if(n2.next == null || n2.next.next == null) return false;
            n2 = n2.next.next;
        }    
        return true;
    }
}
