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
cpublic ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode node = head;
        while(node != null) {
            while(prev != null && node != null && prev.val == node.val) {
                prev.next = node.next;
                node = node.next;
            }
            prev = node;
            if(node != null)
                node = node.next;
        }
        return head;
    }


    ###########
    class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}