###########

 sort O(NlogN), minimum heap O(NlogN) and maximum heap O(NlogK)
#############
import heapq
class Solution:
    def kClosest(self, points: List[List[int]], K: int) -> List[List[int]]:
        distance = []
        for p in points:
            if len(distance) <= K-1:
                heapq.heappush(distance,(-p[0]**2-p[1]**2,p))
            else:
                if -p[0]**2-p[1]**2 > distance[0][0]:
                    heapq.heappop(distance)
                    heapq.heappush(distance,(-p[0]**2-p[1]**2,p))
        res = []
        for i in range (K):
            res.append(heapq.heappop(distance)[1])
        return res
        


###############keep it simple
class Solution:
    def kClosest(self, points: List[List[int]], K: int) -> List[List[int]]:
        heap = []
        for x, y in points:
            d = -(x*x + y*y)
            heappush(heap, (d, x, y))
            if len(heap) > K:
                heappop(heap)
                        
        return [[x, y] for _, x, y in heap]