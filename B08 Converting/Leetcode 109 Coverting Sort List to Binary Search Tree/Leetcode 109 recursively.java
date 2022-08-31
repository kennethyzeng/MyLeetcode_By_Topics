/*


*/ 
public class Solution {
public TreeNode sortedListToBST(ListNode head) {
    if(head==null) return null;
    return toBST(head,null);
}
public TreeNode toBST(ListNode head, ListNode tail){
    ListNode slow = head;
    ListNode fast = head;
    if(head==tail) return null;
    
    while(fast!=tail&&fast.next!=tail){
        fast = fast.next.next;
        slow = slow.next;
    }
    TreeNode thead = new TreeNode(slow.val);
    thead.left = toBST(head,slow);
    thead.right = toBST(slow.next,tail);
    return thead;
}



#######simliar
public class Solution {
public TreeNode sortedListToBST(ListNode head) {
    if(head==null)
        return null;
    ListNode slow = head;
    ListNode fast = head;
    ListNode temp=null;
    
    //find the mid node
    while(fast.next!=null && fast.next.next!=null){
        fast = fast.next.next;
        temp = slow;
        slow = slow.next;
    }
    
    if(temp!=null)
        temp.next = null; //break the link
    else
        head = null;
        
    TreeNode root = new TreeNode(slow.val);
    root.left = sortedListToBST(head);
    root.right = sortedListToBST(slow.next);
    return root;
}