/*
Time Complexity:
Space Complexity:

*/ 

//**
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
        if (head == null) return null; 
        
        if (head.next != null && head.val == head.next.val){
            while (head.next != null && head.val == head.next.val){
                head = head.next; 
            }
            return deleteDuplicates(head);          //difference
        }else{
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }
}