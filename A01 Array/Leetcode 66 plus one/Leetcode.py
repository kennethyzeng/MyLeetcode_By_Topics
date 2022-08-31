###########
Time Complexity:
Space Complexity:


#############
    def plusOne(self, digits: List[int]) -> List[int]:
        
        for i in range(len(digits) - 1, -1, -1):
            if digits[i] != 9:
                digits[i] += 1
                break

            if digits[i] == 9:
                digits[i] = 0
                if i == 0:
                    digits.insert(0, 1)

        return digits

#######recursion; maybe slower

class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        if digits[-1] < 9:
            digits[-1] += 1
            return digits
        elif len(digits) == 1 and digits[0] == 9:
            return [1, 0]
        else:
            digits[-1] = 0
            digits[0:-1] = self.plusOne(digits[0:-1])
            return digits