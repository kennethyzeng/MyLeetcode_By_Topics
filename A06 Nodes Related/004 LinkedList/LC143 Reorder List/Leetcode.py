###########
Time Complexity:
Space Complexity:


#############
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        fast, slow = head.next, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next 
            
        #reverse the second half
        second = slow.next
        pre = slow.next = None
        while second: 
            tmp = second.next
            second.next = pre
            pre = second
            second = tmp
            
        #merge two half
        first, second = head, pre
        while first and second: 
            tmp1, tmp2 = first.next, second.next
            first.next = second
            first.next.next = tmp1
            first, second = tmp1, tmp2
        