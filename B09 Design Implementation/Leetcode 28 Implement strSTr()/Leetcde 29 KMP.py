###########
Time Complexity:
Space Complexity:

Python O(m+n) by KMP
#############
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if haystack == needle:
            return 0
        
        if not needle:
            return 0
        
        len_needle = len(needle)
        len_haystack = len(haystack)

        dp = self.kmp_algo(needle)
        
        i = 0
        j = 0
        
        while i < len_haystack:
            while j > 0 and haystack[i] != needle[j]:
                j = dp[j-1]

            if haystack[i] == needle[j]:
                j += 1            
            i += 1

            if j == len_needle:
                return i - j

        return -1
    
    def kmp_algo(self, needle):
        len_needle = len(needle)
        dp = [0] * len(needle)
        
        i = 1
        j = 0
        
        while i < len_needle:
            while j > 0 and needle[j] != needle[i]:
                j = dp[j-1]
            if needle[i] == needle[j]:
                j += 1
                dp[i] = j

            i += 1
        return dp

###########################################
Implementation by KMP in Python

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        
        # --------------------------------------------------------
        
        # helper function to generate next table for KMP algorithm
        def next_table(pattern):
            
            size_pattern = len(pattern)
            
            # optimal rollback table
            next_arr = [0 for _ in range(size_pattern)]
            
            next_arr[0] = -1
            
            i, j = 0, -1
            
            # compute next table with common prefix substring
            while i < size_pattern-1:
                
                if (j == -1) or (pattern[i] == pattern[j]):
                    
                    # first char, or common prefix exist, go to next character
                    
                    i, j = i+1, j+1
                    next_arr[i] = j
                    
                else:
                    
                    # not match, roll back
                    j = next_arr[j]
            
            return next_arr
        
        # --------------------------------------------------------
        
        # Implement KMP algorithm
        
        if needle == '':
            
            # Return 0 for empty string as pattern
            return 0
        
        # compute optimal rollback table
        next_arr = next_table(needle)
        
        i, j = 0, 0
        size_src, size_pattern = len(haystack), len(needle)
        
        # keep compare character till the end of string
        while i < size_src and j < size_pattern:
            
            if (j == -1) or (haystack[i] == needle[j]):
                
                # if reset or character match, go to compare next one
                i, j = i+1, j+1
            
            else:
                # character mismatch, go back to optimal rollback index
                j = next_arr[j]
                
        
        if j == size_pattern:
            
            # Accept
            return i - size_pattern
        
        else:
            # Reject
            return -1
Implementation by KMP in Go

func strStr(haystack string, needle string) int {
    
    var nextTable func(string) []int
    
    nextTable=func(pattern string) []int{
        
        sizePattern := len(pattern)
        
        // optimal rollback table
        next_arr := make([]int, sizePattern)
        
        next_arr[0] = -1
        
        i, j := 0, -1
        
        for i < (sizePattern-1){
            
            if (j == -1) || (pattern[i] == pattern[j]){
                
                // first character, or common prefix exist
                
                i, j = i+1, j+1
                next_arr[i] = j
            }else{
                
                // not match, roll back
                j = next_arr[j]
            }
        }
        
        return next_arr
        
    }
    //End of inner function nextTable
    
    // Implement KMP algorithm
    
    if needle == ""{
    
        // Return 0 for empty string as pattern
        return 0
    }
    
    // compute optimal rollback table
    next_arr := nextTable(needle)
    
    i, j := 0, 0
    
    sizeSrc, sizePattern := len(haystack), len(needle)
    
    // keep comparing character till the end of string
    for (i < sizeSrc) && (j < sizePattern){
        
        if (j==-1) || (haystack[i] == needle[j]){
            
            // if reset or character match, go to compare next one
            i, j = i+1, j+1
        }else{
            
            // character mismatch, go back to optimal rollback index
            j = next_arr[j]
            
        }
        
    }
    
    if j == sizePattern{
        
        // Accept
        return i - sizePattern
        
    }else{
        
        // Reject
        return -1
    }
    
}
//End of function