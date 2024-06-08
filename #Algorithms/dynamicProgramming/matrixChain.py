"""
sys.maxsise 
https://www.geeksforgeeks.org/sys-maxsize-in-python/

"""
import sys 

def MatrixChain(mat, i, j):
    if i == j:
        return 0
    minimum_computatioins=sys.maxsize 
    for k in range(i,j):
        count = (MatrixChain(mat, i, k) + MatrixChain(mat, k+1, j)+ mat[i-1]*mat[k]*mat[j])
    if count < minimum_computatioins:
        minimum_computatioins=count 
    return minimum_computatioins

matrix_size=[20,30,45,50]
print("Minimum multiplication are", MatrixChain(matrix_size, 1, len(matrix_size)-1))
