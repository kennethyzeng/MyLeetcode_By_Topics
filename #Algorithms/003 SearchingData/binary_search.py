def binary_search(arr, start, end, key):
    """
    Approach: divide the sorted list and compare value of end, then choose left or right
    start: index 
    end: index
    arr: sorted list 
    key: search value
    """

    while start <= end: 
        mid = start + (end-start)//2
        if arr[mid] == key:
            return mid 
        elif arr[mid] < key:
            start = mid + 1 
        else: 
            end =mid -1
    #condition: not match key
    return -1 

arr=[4,6, 9, 13, 14, 18, 21, 24, 38]
x=14
result=binary_search(arr, 0, len(arr)-1, x)
print(result)