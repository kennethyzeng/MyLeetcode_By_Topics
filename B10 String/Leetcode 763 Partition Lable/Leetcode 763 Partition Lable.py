###########
 Two Pointer, Hash Table, O(N) | Explanation
First pass, record last index of each char
Second pass, update most right index, until current index i is same as right; add difference to ans
maintain the most left index of each segment (left)
#############
class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        d = collections.defaultdict(int)
        for i, c in enumerate(S): d[c] = i
        ans, left, right = [], -1, -1
        for i, c in enumerate(S):
            right = max(right, d[c])
            if i == right:
                ans.append(right-left)
                left = i
        return ans