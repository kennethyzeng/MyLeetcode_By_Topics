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
    public ListNode deleteDuplicates(ListNode head) {
        //corner case
        if (head == null) return null; 
        
        if(head.next != null && head.val == head.next.val){
            while(head.next != null && head.val == head.next.val){
                head = head.next;       //if equal, move to last "equal" node
            }   
        
            return deleteDuplicates(head.next);    
            // return next node which after "equal" node  ex: 3->3-> 4     return 4
            
        } else{           //if cur node != next node
            head.next = deleteDuplicates(head.next); 
        }
        return head; 
        
    }
}
