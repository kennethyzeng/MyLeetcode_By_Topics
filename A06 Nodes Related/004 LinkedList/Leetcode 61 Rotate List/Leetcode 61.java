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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head; 
        
        ListNode index = head; 
        
        int count = 1;
        while(index.next != null){
            index= index.next; 
            count ++;
        }
        
        index.next = head;      // connect to last ListNode
        
        for (int i = 1; i < count - k % count; i++ ){
            head = head.next; 
        }
        ListNode res = head.next; 
        head.next = null; 
        
        return res; 
    }
}