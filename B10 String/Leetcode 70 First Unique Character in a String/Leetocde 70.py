###########


#############
class Solution:
    def firstUniqChar(self, s: str) -> int:
        d={}
        for ch in s:
            if ch in d:
                d[ch]+=1
            else:
                d[ch]=1
                
        for key,value in d.items():
            if value==1:
                return s.index(key)
        return -1
#############################



class Solution:
    def firstUniqChar(self, s: str) -> int:
        
        for i in range(len(s)):
            if s.count(s[i]) == 1:
                return i
        return -1
Using Counter:
###########################
class Solution:
    def firstUniqChar(self, s: str) -> int:
        
        # Using Counter
        arr = collections.Counter(s)
        for a, b in arr.most_common():
            if b == 1:
                return s.index(a)
        return -1