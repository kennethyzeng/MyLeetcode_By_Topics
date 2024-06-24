"""
This method is for large number of sorted list data

jump search's two steps
1. compare the last index of each block, determine the condition 
    = 
    >
    <
    Note: check the last block. if the index size is bigger than block size  (case: division is not equally)
2. when find the block which search belonged to, do linear search for specific block

two method: 
-jump search 
-linear search 

Time complexity: n/m + (m-1) since m =sqrt(n), so 2 + (sqrt(n)-1) = sqrt(n) +1 => sqrt(n)

note: NEED TO PAY ATTENTION FOR +BLOCK_SIZE PART
"""
#Step 2: 
def linear_search(sorted_list, term):
    print("Accessing linear search")
    list_size = len(sorted_list)
    for i in range(list_size):
        if term == sorted_list[i]:
            return i 
        elif sorted_list[i] > term: 
            return None 
    return None 

#step 1
def jump_search(sorted_list, item):
    import math 
    print("Enentering Jump Search")
    list_size=len(sorted_list)
    i = 0 
    block_size = int(math.sqrt(list_size))

    while i != len(sorted_list) -1  and item >= sorted_list[i]:
        #step 1-b: handling the case for last block including the size > last index 
        if i + block_size >  len(sorted_list):
            block_size = len(sorted_list) - i    #
            block_list = sorted_list[i : i + block_size]   #+ block_size 
            j = linear_search(block_list, item)
            if j is None: 
                print("Item not found")
                return 
            return i + j

        #step 1-a: three condition for comparision 
        if sorted_list[i + block_size -1] == item:      #but block_size -1
            return i + block_size - 1
        elif sorted_list[i + block_size -1] > item: 
            array_block = sorted_list[i : i + block_size]  #+ block_size ; not include last element
            #print(array_block)
            j = linear_search(array_block, item)
            if j is None: 
                print("Item not found")
                return 
            return i + j 

        # step 1-c: jump block 
        i += block_size
    
###case validation
list =[1,2,3,4,5,6,7,8,9, 10, 11]            
#print(list[2:5])
print(jump_search(list, 10))