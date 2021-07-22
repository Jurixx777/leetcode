/**
* Given the heads of two singly linked-lists headA and headB,
* return the node at which the two lists intersect.
* If the two linked lists have no intersection at all, return null.
*
*
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 **/
 
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode hA = headA;
        ListNode hB = headB;
        int sizeA = 0;
        int sizeB = 0;
        int delta;
        //find size of bouth listA and listB
        while(hA != null || hB != null) {
            if(hA != null) { 
                sizeA++;
                hA = hA.next;
            }
            if(hB != null) {
                sizeB++;
                hB = hB.next;
            }
        }
        //set longer list to head A and compute number of difference between sizes
        if(sizeA > sizeB) {
            hA = headA;
            hB = headB;
            delta = sizeA - sizeB;
        }
        else {
            hA = headB;
            hB = headA;
            delta = sizeB - sizeA;
        }
        //skip an count of items of longer array 
        for(int i = 0; i < delta; i++) {
            hA = hA.next;
        }
        //find intersection
        while(hA != hB && hA != null) {
            hA = hA.next;
            hB = hB.next;
        }
        return hA;
    }
}
