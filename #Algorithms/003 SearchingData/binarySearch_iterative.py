"""
time complexity is O(log n)
"""

def binary_search_iterative(sorted_list, term):
    list_size = len(sorted_list) 
    index_of_first_element = 0 
    index_of_last_element= list_size - 1
    while index_of_first_element <= index_of_last_element:
        mid_point = (index_of_first_element + index_of_last_element) // 2
        #print(mid_point)
        if sorted_list[mid_point] == term:
            return mid_point
        elif sorted_list[mid_point] < term: 
            index_of_first_element = mid_point + 1
        else:
            index_of_last_element = mid_point - 1

    #if index_of_first_element > index_of_last_element:
    #   return None  
    return None

##case validation for numberic and non-nuberic 
store = [1, 4, 5, 12, 43, 54, 60, 77]
a = binary_search_iterative(store, 54)
print( a)


list2 = ['book','data','packt', 'structure']
search_term2 = 'structure'
index_position2 = binary_search_iterative(list2, search_term2)
if index_position2 is None:
    print("The data item {} is not found".format(search_term2))
else:
    print("The data item {} is found at position {}".format(search_term2, index_position2))

