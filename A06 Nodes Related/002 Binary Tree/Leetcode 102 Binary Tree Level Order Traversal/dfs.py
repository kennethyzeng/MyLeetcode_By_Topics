        ## RECURSIVE APPROACH ##
        if not root:    return []
        levels = collections.defaultdict(list)
        def helper(node, level):
            levels[level].append(node.val)
            if node.left:   helper(node.left, level + 1)
            if node.right:  helper(node.right, level + 1)
        helper(root, 0)
        return levels.values()