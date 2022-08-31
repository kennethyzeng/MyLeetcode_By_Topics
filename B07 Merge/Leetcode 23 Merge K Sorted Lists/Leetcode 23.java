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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null; 
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((O1, O2) ->O1.val - O2.val );
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null){
                minHeap.add(lists[i]);
            }
        }
        
        ListNode dummy = new ListNode(-1); 
        ListNode cur = dummy; 
        while(minHeap.size() != 0){
            ListNode node = minHeap.remove(); 
            cur.next = node; 
            cur = cur.next; 
            if(node.next != null) minHeap.add(node.next); 
        }
        return dummy.next; 
    }
}