class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        start = curr = ListNode(0)
        carry = 0
        while(l1 or l2 or carry):
            x = l1.val if l1 else 0
            y = l2.val if l2 else 0
            
            carry, val = divmod(x + y + carry, 10)
            curr.next = ListNode(val)
            curr = curr.next
            
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
        
        return start.next


#############
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        if (l1 == None): return l2
        if (l2 == None): return l1
        
        temp = 0  ##act for carrier
        dummy = ListNode (0)   ##head is dummy
        p = dummy
        
        while(l1 or l2 or temp):  
            if l1: 
                temp += l1.val
                l1 = l1.next
                
            if l2: 
                temp += l2.val
                l2 = l2.next 
                
            p.next = ListNode(temp % 10) ##remainer
            p = p.next
            temp = temp // 10
            
        return dummy.next