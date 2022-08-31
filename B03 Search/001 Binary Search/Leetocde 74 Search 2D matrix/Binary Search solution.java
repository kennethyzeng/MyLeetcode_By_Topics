/*
Time Complexity:
Space Complexity:

*/ 

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length; 
        int start = 0; 
        int end = m *n -1; 
        
        while(start +1 < end){
            int mid = start + (end - start) /2; 
            if(matrix[mid / m][ mid % m] == target) {
                return true; 
            }else if(matrix[mid / m][ mid % m] < target) {
                start = mid; 
            }else{
                end = mid;
            }
        }
        if(matrix[start / m][ start % m] == target) {
            return true; 
        } else if(matrix[end / m][ end % m] == target) {
            return true;
        } else{
            return false; 
        }
        
    }
}

##############
/**
 *  Do binary search in this "ordered" matrix
 */
public boolean searchMatrix(int[][] matrix, int target) {
	
	int row_num = matrix.length;
	int col_num = matrix[0].length;
	
	int begin = 0, end = row_num * col_num - 1;
	
	while(begin <= end){
		int mid = (begin + end) / 2;
		int mid_value = matrix[mid/col_num][mid%col_num];
		
		if( mid_value == target){
			return true;
		
		}else if(mid_value < target){
			//Should move a bit further, otherwise dead loop.
			begin = mid+1;
		}else{
			end = mid-1;
		}
	}
	
	return false;
}
