class Solution(object):
    def convert(self, s, numRows):
        if numRows == 1:
            return s
        
		# Store all levels as arr inside a larger levels arr
        levels = []
        for n in range(numRows):
            levels.append([])

        # Iterate through letters of the string
		# For each letter, append it to the level that corresponds to the level variable below
		# Add step to level to increase/decrease level
        level = 0
        step = 1
        
        for letter in s:
            levels[level].append(letter)
            level += step
            
			# Step turns negative when we reach the last level
			# Step turns positive when we reach the top level
            if level == 0 or level == numRows-1:
                step *= -1
        
		# Convert the list of letter into strings
        for level, string in enumerate(levels):
            levels[level] = ''.join(string)
           
        return ''.join(levels)