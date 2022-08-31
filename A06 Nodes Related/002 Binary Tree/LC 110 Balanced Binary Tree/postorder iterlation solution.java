/*
Time Complexity:
Space Complexity:

*/ 


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public boolean isBalanced(TreeNode root) {
		ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
		TreeNode lastNodeVisited = null;
		TreeNode curr = root;
		HashMap<TreeNode, Integer> nodeVsheight = new HashMap<TreeNode, Integer>();

		while (!stack.isEmpty() || curr != null) {
			if (curr != null) {
				stack.push(curr);
				curr = curr.left;
			} else {
				TreeNode x = stack.peek();
				if (x.right != null && x.right != lastNodeVisited) {
					curr = x.right;
				} else {
					int lH = x.left != null ? nodeVsheight.remove(x.left) : 0;
					int rH = x.right != null ? nodeVsheight.remove(x.right) : 0;

					if (Math.abs(lH - rH) > 1) {
						return false;
					}

					int xH = 1 + Math.max(lH, rH);
					nodeVsheight.put(x, xH);
					stack.pop();
					lastNodeVisited = x;
				}
			}
		}
		return true;
	}