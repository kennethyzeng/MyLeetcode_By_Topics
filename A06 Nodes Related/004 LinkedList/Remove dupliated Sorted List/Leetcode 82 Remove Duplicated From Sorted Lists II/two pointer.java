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
        if(head == null || head.next == null) return head; 
        
        ListNode dummy = new ListNode(-1), slow = dummy, fast = head; 
        slow.next = fast; 
        
        while(fast != null){
            while(fast.next != null && fast.val == fast.next.val){
                fast = fast.next; 
            }
            
            if(slow.next != fast){      //treatment for duplicate
                slow.next = fast.next; 
                fast = slow.next;       //reposition fast 
            }else{                      //no duplciate slow.next = fast
                slow = slow.next; 
                fast = fast.next;
            }
            
        }
        return dummy.next; 
    }
}


############
public class Solution {
public ListNode deleteDuplicates(ListNode head) {
	//use two pointers, slow - track the node before the dup nodes, 
	// fast - to find the last node of dups.
    ListNode dummy = new ListNode(0), fast = head, slow = dummy;
    slow.next = fast;
    while(fast != null) {
    	while (fast.next != null && fast.val == fast.next.val) {
     		fast = fast.next;    //while loop to find the last node of the dups.
    	}
    	if (slow.next != fast) { //duplicates detected.
    		slow.next = fast.next; //remove the dups.
    		fast = slow.next;     //reposition the fast pointer.
    	} else { //no dup, move down both pointer.
    		slow = slow.next;
    		fast = fast.next;
    	}
    	
    }
    return dummy.next;
} }