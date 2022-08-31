###########
Time Complexity:
Space Complexity:


#############
class Solution:
    def deleteDuplicates(self, head):
        p = head
        q = None
        while p and p.next: 
            if p.val == p.next.val: 
                while (p and p.next and p.val == p.next.val): 
                    p = p.next
                p = p.next
                if q is None:
                    head = p
                else:
                    q.next = p
            else:
                q = p
                p = p.next
        return head