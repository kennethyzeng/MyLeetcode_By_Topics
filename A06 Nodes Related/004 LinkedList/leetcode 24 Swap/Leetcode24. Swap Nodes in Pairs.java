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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head; 
        
        ListNode dummy = new ListNode(-1); 
        ListNode curr = dummy;
        dummy.next = head; 
        
        while(curr.next != null && curr.next.next != null){
            ListNode first = curr.next; 
            ListNode second = curr.next.next; 
            
            curr.next = second; 
            first.next = second.next; 
            second.next = first; 
            curr = curr.next.next; 
        }
        return dummy.next; 
    }
}
