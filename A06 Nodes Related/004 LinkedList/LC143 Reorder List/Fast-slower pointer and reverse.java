/*
Time Complexity:  O(N)
Space Complexity:  O(1)

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
    public void reorderList(ListNode head) {
        if (head == null) return; 
        
        ListNode mid = findMid(head);
        ListNode l2 = mid.next; 
        mid.next = null; 
        ListNode l1 = head;
        l2 = reverse(l2);
        
        while(l1 != null && l2 != null){
            ListNode next = l1.next; 
            l1.next = l2; 
            l2 = l2.next; 
            l1.next.next =next; 
            l1 = next;
        }
    }
    
    public ListNode findMid(ListNode head){
        ListNode fast = head, slow = head; 
        while(fast != null && fast.next != null){
            slow = slow.next; 
            fast = fast.next.next;
        }
        return slow; 
    }
    
    public ListNode reverse(ListNode head){
        ListNode newHead = null;
        while (head != null){
            ListNode next = head.next; 
            head.next = newHead; 
            newHead = head; 
            head = next; 
        }
        return newHead;
    }
    
    
}
