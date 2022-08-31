class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        
        # key: memory id of original node
        # value: corresponding deep copy node
        mapping = {}
        
        # -----------------------------------------
        def helper( node: 'Node' ) -> 'Node':
            
            if not node:
    
                # empty node's deep copy is still empty node
                return node
            
            elif id(node) in mapping:
                
                # current node already has deep copy
                return mapping[ id(node) ]
            
            # create deep copy for current node
            mapping[ id(node) ] = Node( val=node.val, neighbors=[] )
            
            for original_neighbor in node.neighbors:
                # update neighbor list for current node
                mapping[ id(node) ].neighbors.append( helper(original_neighbor) )
            
            return  mapping[ id(node) ]
        
        # -----------------------------------------
        return helper( node )