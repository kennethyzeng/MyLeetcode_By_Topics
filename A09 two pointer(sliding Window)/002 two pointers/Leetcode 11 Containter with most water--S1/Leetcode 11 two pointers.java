/*
Runtime: 7 ms, faster than 16.09% of Java online submissions for Container With Most Water.
Memory Usage: 79 MB, less than 7.16% of Java online submissions for Container With Most Water.

*/ 


class Solution {
    public int maxArea(int[] height) {
        int i = 0;  //left pointer
        int j = height.length -1;   //right pointer 
        int area = Integer.MIN_VALUE; 
        
        while(i < j){
            int min_height = Math.min(height[i], height[j]);
            area = Math.max(area, min_height *(j-i));
            
            if (height[i] < height[j]){
                i++;
            }else{
                j --;
            }
        }
        return area; 
    }
}