/*
It's a good chance to use In Order Traveral here, where we traverse Left - Root - Right.
Firstly, we calculate of number of elements in the linked list, let name it n.
We keep global head, in the beginning head points to the first element in the BST.
Let dfs(left, right) return the root of the height balanced BST when building in elements from left to right of the linked list.
Our answer is the root which is returned from dfs(0, n-1).
In dfs(left, right) function:
mid = (left + right) / 2
Firstly, we build BST left subtree, by leftNode = dfs(left, mid-1), after finish building left subtree, now head will point to the mid element.
So we take the root value from head.val and move head to next, by root = TreeNode(head.val); head = head.val
Finally, we build the right node of the root, by rightNode = dfs(mid+1, right).

Solution 2: InOrder Traversal
Time: O(N)
Extra Space: O(logN), because the depth of the buildBST recursion take logN
*/ 
class Solution {
    ListNode head;
    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;
        return buildBST(0, length(head) - 1);
    }
    TreeNode buildBST(int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode leftNode = buildBST(left, mid - 1);
        
        TreeNode root = new TreeNode(head.val); // root node is the mid node
        head = head.next; // go next
        
        root.left = leftNode;
        root.right = buildBST(mid + 1, right);
        return root;
    }
    int length(ListNode head) {
        int ans = 0;
        while (head != null) {
            head = head.next;
            ans++;
        }
        return ans;
    }
}

####python
class Solution:
    def sortedListToBST(self, head: ListNode) -> TreeNode:
        def length(head):
            cnt = 0
            while head != None:
                cnt += 1
                head = head.next
            return cnt
        
        def dfs(left, right):
            nonlocal head
            if left > right: return None
            mid = (left + right) // 2
            leftNode = dfs(left, mid - 1)
            
            root = TreeNode(head.val)
            head = head.next
            
            root.left = leftNode
            root.right = dfs(mid + 1, right)
            return root
        
        return dfs(0, length(head)-1)