"""
Two method: 
    -use exponential_search to locate block of the search term 
    -then use binary search to find index position

time mcomplexity 
2^i = n    #n is number of toal elements    
time complexity for exponential search is O(i) 
time complexity for binary search is O(log (i))
O(i * log(i))
where is i the index where the elemtn to be searched is present
"""
def binary_search_recursive(sortedlist, start_index, last_index, term):
    if (last_index < start_index):
        return None 
    else:
        mid_point=start_index + (last_index - start_index)//2    #key method
        if sortedlist[mid_point] == term:
            return mid_point
        elif sortedlist[mid_point] < term:
            return binary_search_recursive(sortedlist,mid_point+1, last_index, term)
        else:
            return binary_search_recursive(sortedlist,start_index, mid_point-1, term)
        

def exponential_search(sortedlist, term):
    if sortedlist[0] == term: 
        return 0 
    index = 1
    while index < len(sortedlist) and sortedlist[index] < term: 
        index *=2
    return binary_search_recursive(sortedlist, index//2, min(index, len(sortedlist)-1), term)

##case validation
print(exponential_search([1,2,3,4,5,6,7,8,9,10,11,12,34,40],34)) 