"""
Search index position of unsorted list 

worst cast time complexity  O(n)

"""

def search_ordered_list(unsorted_list, term):
    ordered_list_size = len(unsorted_list) 
    for i in range (ordered_list_size):
        if term == unsorted_list[i]:
            return i 
    
    return None 


###cases valiation below
#numeric case
list1 = [60, 1, 88, 10, 11, 600] 
search_term = 10 
index_position=search_ordered_list(list1, search_term)

if index_position is None: 
    print("{} is not found".format(search_term))
else: 
    print("{} is found at index {}".format(search_term, index_position))

#non_numberic case 
list2 = ['packt', 'publish', 'data'] 
search_term2 = 'data' 
index_position2=search_ordered_list(list2, search_term2)

if index_position2 is None: 
    print("{} is not found".format(search_term2))
else: 
    print("{} is found at index {}".format(search_term2, index_position2))


