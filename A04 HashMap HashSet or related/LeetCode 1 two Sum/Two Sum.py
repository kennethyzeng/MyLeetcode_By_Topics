def twoSum(self, nums: List[int], target: int) -> List[int]:
        # Brute force
        
        for index, num in enumerate(nums):
            for other_index, other_num in enumerate(nums):
                if num + other_num == target and index != other_index:
                    return [index, other_index]
                
        # Two pass hash table
        
        hash_table = {n: i for i, n in enumerate(nums)}
        # Creates a hash table with each number and their indexes
        for i, n in enumerate(nums):
            complement = target - n # Gets the complement of the number
            if complement in hash_table.keys() and hash_table[complement] != i:
                # Check if the complement is in the hash table
                return [i, hash_table[complement]]
                # Returns the index and the index of the complement
                
                
        # One pass hash table
        
        hash_table = {}
        # Creates the hash table
        for i, n in enumerate(nums):
            complement = target - n
            # Gets the complement
            if complement in hash_table.keys():
                # Check if the complement exists, then returns
                return [i, hash_table[complement]]
            hash_table[n] = i
            # Otherwise it adds the number and index to the hash table