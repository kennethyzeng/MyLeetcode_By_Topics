###########
https://www.goodtecher.com/leetcode-159-longest-substring-with-at-most-two-distinct-characters/
Time Complexity: ~N
Space Complexity: ~1
#############
class Solution:
    def lengthOfLongestSubstringTwoDistinct(self, s: str) -> int:
        if not s:
            return ""
        
        
        max_length = 1
        j = 0
        counter = {}
        
        for i in range(len(s)):
            while j < len(s) and (len(counter) < 2 or (len(counter) == 2 and s[j] in counter)):
                counter[s[j]] = counter.get(s[j], 0) + 1
                j += 1
                
            if len(counter) <= 2:
                max_length = max(max_length, j - i)
                
            counter[s[i]] -= 1
            
            if counter[s[i]] == 0:
                del counter[s[i]]
                
                
        return max_length