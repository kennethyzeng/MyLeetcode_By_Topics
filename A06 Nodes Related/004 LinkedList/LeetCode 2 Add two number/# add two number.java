/*
p.next = new ListNode(tmp%10);
p = p.next;

dummy move to next linkedlist and set the next linkedlist as currt one


carrier = carrier/10;    carrier 1 for next level linkedlist addition
*/ 



public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if(l1==null) return l2;
    if(l2==null) return l1;
    
    ListNode head = new ListNode(0);
    ListNode p = head;
    
    int carrier = 0;
    while(l1!=null || l2!=null || carrier!=0) {
        if(l1!=null) {
            carrier += l1.val;
            l1 = l1.next;
        }
        if(l2!=null) {
            carrier += l2.val;
            l2 = l2.next;
        }
        
        p.next = new ListNode(carrier%10);
        p = p.next;
        carrier = carrier/10;
    }
    return head.next;
}