######time complexity o(n)

# Iteratively
def reverseList1(self, head):
    node = None
    while head:
        tmp = head.next
        head.next = node
        node = head
        head = tmp
    return node
 
# Recursively    
def reverseList(self, head):
    return self.helper(head, None)
    
def helper(self, head, node):
    if not head:
        return node
    tmp = head.next
    head.next = node
    return self.helper(tmp, head)

####
class Solution:
    def reverseList(self, head: ListNode, prev=None) -> ListNode:
        if not head:
            return prev
        temp = head.next
        head.next = prev
        return self.reverseList(temp, head)