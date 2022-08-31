###########
Approach #2. Recursive
Recursively create copy of each node and connect their random nodes
Time: O(n); Space: O(n)

#############
class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        d = dict()
        def deep_copy(node):
            if not node: return
            if node in d: return d[node]
            d[node] = n = Node(node.val)
            n.next = deep_copy(node.next)
            n.random = deep_copy(node.random)
            return n
        return deep_copy(head)