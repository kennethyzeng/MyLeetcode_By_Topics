/*
Time: O(n)
Space: O(1)

*/ 


class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int resultA = Math.min(countRotation(tops[0], tops, bottoms), countRotation(tops[0], bottoms, tops));
        int resultB = Math.min(countRotation(bottoms[0], tops, bottoms), countRotation(bottoms[0], bottoms, tops));
        int result = Math.min(resultA, resultB); 
        return result ==Integer.MAX_VALUE? -1:result;
        
    }
    
    private int countRotation(int target, int[] A, int[] B){
        int count = 0; 
        for(int i = 0; i < A.length; i++){
            if (A[i] != target){
                if (B[i] == target) {
                    count ++;
                }else{
                    return Integer.MAX_VALUE;
                }
            }
        }
        return count;
    }
}