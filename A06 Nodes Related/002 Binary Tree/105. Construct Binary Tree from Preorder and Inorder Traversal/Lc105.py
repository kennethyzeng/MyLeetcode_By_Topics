###########
Time Complexity:
Space Complexity:


#############

  def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        
        if not preorder or not inorder:
            return None

        if len(preorder) == 1:
            return TreeNode(preorder[0])
        
        root = TreeNode(preorder[0])
        root_index = inorder.index(preorder[0])
       
        root.left = self.buildTree(preorder[1:root_index + 1],inorder[:root_index])
        root.right = self.buildTree(preorder[root_index + 1:],inorder[root_index + 1:])
        
        return root

#################

def buildTree(self, preorder, inorder):
    if inorder:
        ind = inorder.index(preorder.pop(0))
        root = TreeNode(inorder[ind])
        root.left = self.buildTree(preorder, inorder[0:ind])
        root.right = self.buildTree(preorder, inorder[ind+1:])
        return root

########
  def buildTree(self, preorder, inorder):
  
        if len(inorder) == 0:
            return None

        if len(inorder) == 1:
            return TreeNode(preorder[0])
        
        rval = preorder[0]
        root = TreeNode(rval)
        
        inorder_rval_index = inorder.index(rval)
        left_inorder = inorder[:inorder_rval_index]
        right_inorder = inorder[inorder_rval_index+1:]
        left_preorder = preorder[1: len(left_inorder) + 1]
        right_preorder = preorder[1 + len(left_preorder):]
        
        root.left = self.buildTree(left_preorder, left_inorder)
        root.right = self.buildTree(right_preorder, right_inorder)
        
        return root