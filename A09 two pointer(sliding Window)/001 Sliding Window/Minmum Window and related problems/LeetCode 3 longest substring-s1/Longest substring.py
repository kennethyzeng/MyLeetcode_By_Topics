https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/742926/Simple-Explanation-or-Concise-or-Thinking-Process-and-Example
#####################################
This method is same as the hashmap solution which store char as key, lastest index as vale 
left is locate the start index of no-repeating substring

#####################################

def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int abcabcbb
        """
        if len(s) == 0:
            return 0
        seen = {}
        left, right = 0, 0
        longest = 1
        while right < len(s):
            if s[right] in seen:
                left = max(left,seen[s[right]]+1)
            longest = max(longest, right - left + 1)
            seen[s[right]] = right
            right += 1
            print(left, right, longest)
        return longest
        
############################
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if (len(s) == 0):
            return 0
        
        seen = {}           ##dict
        left, right = 0, 0
        longest = 1
        
        while right < len(s):
            if s[right] in seen:
                left = max(left, seen[s[right]] +1)
            
            longest = max(longest, right - left +1)
            seen[s[right]] = right
            right += 1
            
        return longest
        