class Solution:
    def intToRoman(self, num: int) -> str:
        
        vals = [ 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 ]
        romans = [ "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" ]
        
        res=''
        
        for i,v in enumerate(vals):
            
            res += (num//v) * romans[i];
            num %= v
            
        return res



##########
class Solution:
    def intToRoman(self, num: int) -> str:
        
        values = [ 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 ]
        numerals = [ "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" ]
        res = ""
        i = 0
        # keep using the largest numerals possible, else increase i
        while num > 0:
            if num>=values[i]:
                res+=numerals[i]
                num-=values[i]
            else:
                i+=1
        return res