###########
Time Complexity:
Space Complexity:


#############


class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        if head:                                           # first (head) node exists
            h = head.next                                  # second node
            if h:                                          # second node exists => a pair exists
                h.next, head.next = head, h.next           # swap node pair, first node with second => 'h' is new head
                h.next.next = self.swapPairs(h.next.next)  # recurse on next pair head
                return h              # returns the new head of a swapped node pair
        return head                   # returns when a node pair doesn't exist
        
        
        
# Iteratively
def swapPairs1(self, head):
    dummy = p = ListNode(0)
    dummy.next = head
    while head and head.next:
        tmp = head.next
        head.next = tmp.next
        tmp.next = head
        p.next = tmp
        head = head.next
        p = tmp.next
    return dummy.next
 
# Recursively    
def swapPairs(self, head):
    if head and head.next:
        tmp = head.next
        head.next = self.swapPairs(tmp.next)
        tmp.next = head
        return tmp
    return head