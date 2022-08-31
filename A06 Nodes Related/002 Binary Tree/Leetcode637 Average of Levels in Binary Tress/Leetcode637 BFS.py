class Solution(object):
    def averageOfLevels(self, root):
        if root is None:
            return []
        
        lst = [[root]]
        for elem in lst:
            record = []
            for c in elem:
                if c.left: record.append(c.left)
                if c.right: record.append(c.right)
            if record:
                lst.append(record)
                
        values = [[x.val for x in z ] for z in lst]
        return [sum(v) / float(len(v)) for v in values]