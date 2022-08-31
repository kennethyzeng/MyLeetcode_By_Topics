/*


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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       //corner case 
        if (l1 == null) return l2; 
        if (l2 == null) return l1; 
        if (l1 == null && l2 == null) return null; 
        
        ListNode dummy = new ListNode(-1); 
        ListNode cur = dummy; 
        
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                cur.next = l1; 
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next; 
            }
            cur = cur.next;
        }
        cur.next = l1 != null? l1: l2;
        return dummy.next; 
    }
    
}