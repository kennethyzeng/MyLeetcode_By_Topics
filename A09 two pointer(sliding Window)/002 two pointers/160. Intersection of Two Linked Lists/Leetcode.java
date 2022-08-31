/*
Time Complexity: O(N)
Space Complexity: O(1)

*/ 


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;  
	    // if (a == null) a = headB;
	//	else a = a.next


            b = b == null ? headA : b.next;
        }
        return a;
    }
}