/*
Dynamic programming: three different code below. same concept

Time: O(nk)
Space: O(1)
*/ 
class Solution{
    public int minCostII(int[][] costs){
        //corner case 
        if (costs == null || costs.length == 0) return 0; 

        int n = costs.length, k = costs[0].length; 
        int min1 = -1 , min2 =-1; 
        for(int i =0; i < n; i ++){
            int last1 = min1, last2 = min2;    //tracking the index location for previous min value and second min
            int min1 = -1, min2 = -1;           //reset when move to next row
            for (int j= 0; j < k; j++){
                if(j != last1){                 //if the current index is same color with previous min
                    costs[i][j] += last1 < 0 ? 0 : costs[i-1][last1];
                }else{                          //same color
                    costs[i][j] += last2 < 0? 0 : costs[i-1][last2];
                }

                // search min1 and min2 for current row 
                if(min1 < 0 || costs[i][j] < costs[i][min1]){
                    min2 = min1; 
                    min1 = j; 

                }else if(min2 < 0 || costs[i][j] < cost[i][min2]){
                    min2 = j; 
                }

            }
        }
        return costs[n-1][min1]; 
    }
}