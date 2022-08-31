public boolean isValidBST (TreeNode root){
		   Stack<TreeNode> stack = new Stack<TreeNode> ();
		   TreeNode cur = root ;
		   TreeNode pre = null ;		   
		   while (!stack.isEmpty() || cur != null) {			   
			   if (cur != null) {
				   stack.push(cur);
				   cur = cur.left ;
			   } else {				   //cur = null
				   TreeNode p = stack.pop() ;
				   if (pre != null && p.val <= pre.val) {				   //if don't have these three lines,	   
					   return false ;									   //it is inorder traversalcodes	
				   }				   									   //	
				   pre = p ;					   
				   cur = p.right ;
			   }
		   }
		   return true ; 
	   }