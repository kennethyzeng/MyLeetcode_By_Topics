public int countNodes(TreeNode root) {
    if (root == null) {
        return 0;
    }
    int l = leftHeight(root.left);
    int r = leftHeight(root.right);
    if (l == r) { // left side is full
        return countNodes(root.right) + (1<<l);
    } 
    return countNodes(root.left) + (1<<r);
}

private int leftHeight(TreeNode node) {
    int h = 0;
    while (node != null) {
        h++;
        node = node.left;
    }
    return h;
}

########
public int countNodes(TreeNode root) {
        int sum = 0;

        while (root != null) {
            int llh = leftDepth(root.left);
            int lrh = rightDepth(root.left);
            int rrh = rightDepth(root.right);
            if (llh == rrh) {
                sum += (1 << llh + 1) - 1;
                break;
            } else if (llh > lrh) {
                sum += 1 << rrh;
                root = root.left;
            } else {
                sum += 1 << llh;
                root = root.right;
            }
        }
        return sum;
    }

    public int leftDepth(TreeNode root) {
        int h = 0;
        while (root != null) {
            root = root.left;
            h++;
        }
        return h;
    }

    public int rightDepth(TreeNode root) {
        int h = 0;
        while (root != null) {
            root = root.right;
            h++;
        }
        return h;
    }