/*
Time Complexity:
Space Complexity:

*/ 

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
    public ListNode partition(ListNode head, int x) {
        //corner case
        if (head == null || head.next == null) return head; 
        
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0); 
        ListNode cur1 = dummy1, cur2 = dummy2; 
        
        while(head != null){
            if(head.val <  x){
                cur1.next = head; 
                cur1 = cur1.next; 
            }else {
                cur2.next = head; 
                cur2 = cur2.next; 
            }
            head = head.next; 
        }
        cur1.next = dummy2.next; 
        cur2.next = null; 
        return dummy1.next; 
    }
}
