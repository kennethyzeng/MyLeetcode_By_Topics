##############
Algorithm
Every point in the output is either at the begining or end of a building. Build a sorted list of building begin / end points (transitions).
For each transiton point:
A. If any buildings begin at the current point: push (height, rightEnd) into a maxheap.
B. Pop the heaproot until the heaproot's right end is at or after the current point.
C. Add point to output if the height at the heaproot is different from the previous output height
Complexity
Time
Building the list of transitions is O(n log n).

We make O(n) calls to heappush() and heappop(). Each call is O(log n), so all heap operations take O(n log n) time.

Total time complexity is O(n log n) + O(n log n) = O(n log n).

Memory
The transitions list uses O(n) space.

#############
from collections import namedtuple
from collections import defaultdict
import heapq

# NamedTuples make code more readable.
Point = namedtuple('point',['x', 'y'])
Building = namedtuple("building",['left','right','height'])
# heap entry, height is negative
Rooftop = namedtuple('rooftop',['height','rightEnd'])

class Solution: 
    def getSkyline(self, buildings: List[List[int]]) -> List[List[int]]:
        # Named tuple conversion.
        buildings = [Building(*b) for b in buildings]
        
        # Build a list of transition points where a building either begins or ends.
        transitions: List[int] = [ b.left for b in buildings ] + [b.right for b in buildings]
		# Deduplicate and sort.
        transitions = sorted(list(set(transitions)))
                
        # left -> building
        buildDict: Dict[int, Building] = defaultdict(set)
        for b in buildings:
            buildDict[b.left] |= {b}
        
        roofHeap: List[Rooftop] = []
        out: List[Point] = []
        lastHeight: int = 0
        
		# Iterate through building transition points.
        for x in transitions:
            # Add new rooftops that start at this transition point.
            for b in buildDict[x]:
                # heapq only supports minheap, so use negative height for maxheap.
                rooftop = Rooftop(-b.height, b.right)
                heapq.heappush(roofHeap, rooftop)
            
            # Remove rooftop at root of heap if the rooftop's right end is before the current transition point.
            while roofHeap and roofHeap[0].rightEnd <= x:
                throwaway = heapq.heappop(roofHeap)
            
            # Add a point if the heaproot height is different from previous height.
            maxHeight = 0
            if roofHeap:
                # Negate to extract max from minheap.
                maxHeight = -roofHeap[0].height
            if maxHeight != lastHeight:
                lastHeight = maxHeight
                p = Point(x, maxHeight)
                out.append(p)
                
        return out