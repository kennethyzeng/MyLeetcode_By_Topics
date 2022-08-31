###########

Approach #1. Iterative
Use hash table to store information {original_node: new_node}
Two pass
First create new node and connect with next
Second use hash table to connect random node
Time: O(n); Space: O(n)
#############
class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        d = {None:None}
        dummy = Node(-1)
        cur, new_cur = head, dummy
        while cur:
            new_cur.next = d[cur] = Node(cur.val)
            cur, new_cur = cur.next, new_cur.next
        cur, new_cur = head, dummy.next
        while cur:
            new_cur.random = d[cur.random]
            cur, new_cur = cur.next, new_cur.next
        return dummy.next 