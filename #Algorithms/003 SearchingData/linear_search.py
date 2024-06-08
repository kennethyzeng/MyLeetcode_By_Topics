#linear search program to search an element, return the index position of the array 

def linearSearch(arr, element):
    for index, value in enumerate(arr):
        if value == element: 
            return index 

    return -1 

inpust_list=[3,4,1,6,14]
element = 4
print(linearSearch(inpust_list,element))