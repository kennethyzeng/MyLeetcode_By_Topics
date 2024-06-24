"""
recursive Method 1
"""

def binary_search_recursive(sortedlist,start_index, end_index, term):
    while start_index <= end_index:
        mid_point = start_index + (end_index - start_index)//2 
        if sortedlist[mid_point] == term:
            return mid_point
        elif sortedlist[mid_point] < term: 
            return binary_search_recursive(sortedlist, mid_point+1, end_index, term)
        else:
            return binary_search_recursive(sortedlist, start_index,  mid_point -1, term)
    return None


list1 = [10, 30, 100, 120, 500]

search_term = 15
index_position1 =  binary_search_recursive(list1, 0, len(list1)-1, search_term)
if index_position1 is None:
    print("The data item {} is not found".format(search_term))
else:
    print("The data item {} is found at position {}".format(search_term, index_position1))


list2 = ['book','data','packt',  'structure']

search_term2 = 'data'
index_position2 = binary_search_recursive(list2, 0, len(list1)-1, search_term2)
if index_position2 is None:
    print("The data item {} is not found".format(search_term2))
else:
    print("The data item {} is found at position {}".format(search_term2, index_position2))