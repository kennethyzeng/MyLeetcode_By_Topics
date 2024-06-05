"""
merge_sort fuction:  Time complexity for recurisve  T=O(logn)
    break down the unsroted_list into smaller sub-problem. use recursive methodology to break it into samllest part then solve problem 

merge function:      T(x)=O(n) for merge step
    compare and sort the two sublist and merge them into one list

so run time complexity O(logn)T(n)=O(logn)O(n)=O(nlogn)
"""
def merge_sort(unsorted_list):
    if len(unsorted_list) ==1:
        return unsorted_list
    mid_point= int(len(unsorted_list)/2)   #ormid_point= len(unsorted_list)//2 ?
    first_half=unsorted_list[:mid_point]
    second_half=unsorted_list[mid_point:]

    half_a=merge_sort(first_half)
    half_b=merge_sort(second_half)

    return merge(half_a, half_b)

def merge(first_sublist, second_sublist):
    i = j = 0
    merge_list=[]
    while i < len(first_sublist) and j < len(second_sublist):
        if first_sublist[i] < second_sublist[j]:
            merge_list.append(first_sublist[i])
            i += 1
        else:
            merge_list.append(second_sublist[j])
            j +=1 
    
    #codnition 1: length of first lenght is bigger length of second length. handle the rest element after above while loop
    while i < len(first_sublist):
        merge_list.append(first_sublist[i])
        i +=1
    #condition 2: verse advice 
    while j < len(second_sublist):
        merge_list.append(second_sublist[j])
        j +=1
    
    return merge_list

#case validation:
a = [11, 12, 7, 41, 61, 13, 16, 14, 1]
b = [11, 12, 7, 41, 61, 13, 16, 14, 12]
c = [11, 12, 7, 41, 61, 13, 16, 14]
print(merge_sort(a))
print(merge_sort(b))
print(merge_sort(c))
