class Solution:
    def calculate(self, s: str) -> int:
        if not s: return 0 
        
        stack, curr_num, operator = [], 0, "+"
        all_operator = ["+", "-",  "*", "/"]
        nums = set(str(x) for x in range(10))
        
        for index in range(len(s)):
            char = s[index]
            
            if char in nums: 
                curr_num = curr_num * 10 + int(char)
                
            if char in all_operator or index == len(s)-1:
                if operator == "+":
                    stack.append(curr_num)
                
                if operator == "-":
                    stack.append(-curr_num)
                    
                if operator == "*":
                    #stack.append(stack.pop()*curr_num)
                    stack[-1] = int(stack[-1] * curr_num)
                    
                if operator == "/":
                    stack[-1] = int(stack[-1] / curr_num)
                    
                operator  = char
                curr_num = 0
                
        return sum(stack)

##################

class Solution:
    def calculate(self, s: str) -> int:
        num, presign, stack=0, "+", []
        for i in s+'+':
            if i.isdigit():
                num = num*10 +int(i)
            elif i in '+-*/':
                if presign =='+':
                    stack.append(num)
                if presign =='-':
                    stack.append(-num)
                if presign =='*':
                    stack.append(stack.pop()*num)
                if presign == '/':
                    stack.append(math.trunc(stack.pop()/num))
                presign = i
                num = 0
        return sum(stack)