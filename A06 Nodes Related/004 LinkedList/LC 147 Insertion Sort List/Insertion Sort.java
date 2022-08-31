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
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(-1); 
        dummy.next = head; 
        ListNode curr = head; 
        ListNode prev = null; 
        ListNode tmp = null;
        
        while(curr != null && curr.next != null) {
            if(curr.val <= curr.next.val){
                curr = curr.next;
            } else{
                tmp = curr.next;
                curr.next = curr.next.next;
                prev = dummy; 
                while(prev.next.val <= tmp.val){
                    prev = prev.next;
                }
                tmp.next = prev.next;
                prev.next = tmp;
            }
           
        }
        return dummy.next; 
    }
}