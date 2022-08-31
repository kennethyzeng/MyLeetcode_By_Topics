###########
Time Complexity:
Space Complexity:


#############
class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        n1, n2 = len(num1), len(num2)
        digit = [0] * (n1 + n2)
        for i in reversed(range(n1)):
            for j in reversed(range(n2)):
                k = i + j
                total = digit[k + 1] + (ord(num1[i]) - ord('0')) * (ord(num2[j]) - ord('0'))
                digit[k] += total // 10
                digit[k + 1] = total % 10
        ans = ''
        for d in digit:
            if not ans and d == 0: continue
            ans += str(d)
        return ans or '0'






#############


class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        return str(self.strint(num1)*self.strint(num2))
    def strint(self,n):
        result=0
        for i in range(len(n)):
            result = result*10 + ord(n[i])-ord('0')
        return result

##################
         Success
    Details 
    Runtime: 32 ms, faster than 92.76% of Python3 online submissions for Multiply Strings.
    Memory Usage: 14.3 MB, less than 30.94% of Python3 online submissions for Multiply Strings.
    s1 = 0
    for i in num1:
        s1 = s1*10 + (ord(i) - 48)  #ord() function returns the number representing the unicode code of a specified character. and the reason we deducted 48 beacuse ascii value of 2 is 50 so if we won't deduct 48 which is the ascii value of 0 it will return 50 and yes you may try this with any no.
        
     # similary we will do for s2    
    s2 = 0
    for i in num2:
        s2 = s2*10 + (ord(i) - 48)
        
  # and just return the value      
    return (str(s1 * s2))  
	#I hope things are clear now but still if you have any query comment down I will reply asap