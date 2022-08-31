/*
Time Complexity:  O(n)
Space Complexity: 0(height)

*/ 

/public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        List<Integer> path = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        // sum along the current path
        int pathSum = 0;
        TreeNode prev = null;
        TreeNode curr = root;
        while (curr != null || !s.isEmpty()){
            // go down all the way to the left leaf node
            // add all the left nodes to the stack 
            while (curr != null){
                s.push(curr);
                // record the current path
                path.add(curr.val);
                // record the current sum along the current path
                pathSum += curr.val;
                curr = curr.left;
            }
            // check left leaf node's right subtree 
            // or check if it is not from the right subtree
            // why peek here? 
            // because if it has right subtree, we don't need to push it back
            curr = s.peek();
            if (curr.right != null && curr.right != prev){
                curr = curr.right;
                continue; // back to the outer while loop
            }
            // check leaf 
            if (curr.left == null && curr.right == null && pathSum == sum){
                list.add(new ArrayList<Integer>(path));
                // why do we need new arraylist here?
                // if we are using the same path variable path
                // path will be cleared after the traversal
            }
            // pop out the current value
            s.pop();
            prev = curr;
            // subtract current node's val from path sum 
            pathSum -= curr.val;
            // as this current node is done, remove it from the current path
            path.remove(path.size()-1);
            // reset current node to null, so check the next item from the stack 
            curr = null;
        }
        return list;
    }