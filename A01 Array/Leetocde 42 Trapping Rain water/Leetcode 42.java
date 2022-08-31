/*


*/ 

class Solution {
    public int trap(int[] height) {
        int peak_index = 0; 
        for (int i = 0; i < height.length; i ++){
            if (height[i] > height[peak_index])
                peak_index = i;
        }
        
        int leftMostBar = 0;
        int water = 0; 
        //from left to peak_index
        for (int i = 0; i < peak_index; i++){
            if (height[i] > leftMostBar)
                leftMostBar = height[i]; 
            else {
                water = water + leftMostBar - height[i];
            }
        }
        
        //from right to peak_index
        int rightMostBar = 0; 
        for (int i = height.length - 1; i > peak_index; i-- ){
            if (height[i] > rightMostBar){
                rightMostBar = height[i]; 
            }else{
                water = water + rightMostBar - height[i];
            }
        }
        return water; 
    }
}
