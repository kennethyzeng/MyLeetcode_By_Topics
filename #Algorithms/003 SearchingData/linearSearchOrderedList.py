"""
Search index position of sorted list 

worst cast time complexity  O(n)
It will stop and break when the number is greater than search item 
"""

def search_ordered_list(sorted_list, term):
    ordered_list_size = len(sorted_list) 
    for i in range (ordered_list_size):
        if term == sorted_list[i]:
            return i 
        elif sorted_list[i] > term:
            return None 
    
    return None 


###cases valiation below
#numeric case
list1 = [2, 3, 4, 5, 7]
search_term = 6 
index_position=search_ordered_list(list1, search_term)

if index_position is None: 
    print("{} is not found".format(search_term))
else: 
    print("{} is found at index {}".format(search_term, index_position))

#non_numberic case 
list2 = ['book', 'data', 'packt','structure']
search_term2 = 'structure'
index_position2=search_ordered_list(list2, search_term2)

if index_position2 is None: 
    print("{} is not found".format(search_term2))
else: 
    print("{} is found at index {}".format(search_term2, index_position2))


