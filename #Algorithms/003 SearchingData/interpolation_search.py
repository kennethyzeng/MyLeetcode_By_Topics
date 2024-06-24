
def nearest_mid(sortedlist, low_index, upper_index, search_term):
    mid= low_index + (upper_index - low_index)/(sortedlist[upper_index]-sortedlist[low_index]) * (search_term-sortedlist[low_index]) 
    return int(mid)

def interpolation_search(sortedlist, search_term):
    low_index = 0 
    upper_index = len(sortedlist) -1
    while low_index <= upper_index:
        mid_point = nearest_mid(sortedlist, low_index, upper_index, search_term)
        if (sortedlist[mid_point] == search_term):
            return mid_point
        elif sortedlist[mid_point] < search_term:
            low_index = mid_point + 1
        else: 
            upper_index = mid_point - 1
    # if low_index > upper_index:
    #     return None
    return None 

###cases validation
list1 = [44, 60, 75, 100, 120, 230, 250]
a = interpolation_search(list1, 120)
print("Index position of value 2 is ", a)        

print(nearest_mid(list1, 0, 6, 120))


