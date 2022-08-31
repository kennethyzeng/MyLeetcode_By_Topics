###########
Time Complexity:
Space Complexity:


#############
class Solution:
    def advantageCount(self, A: List[int], B: List[int]) -> List[int]:
        B = deque(sorted(zip(B, count()))); ret = [None]*len(B)
        for a in sorted(A):
            ret[B.popleft()[1] if a > B[0][0] else B.pop()[1]] = a
        
        return ret