/*
Python O( n ) by boundary checking

*/ 

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int i = 0; 
        
       /* //corner case: 
        if (newInterval[1] < intervals[0][0]){
            
        }
        if (newInterval[0] > intervasl[invervals.length -1][1]){
            
        }
        */
        
        //condition 1: part before overlap
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            list.add(new int[] {intervals[i][0], intervals[i][1]});
            i++;
        }
        
        
        //condition 2: overlap part
        //int min = 0, max = 0;
        while (i < intervals.length && intervals[i][0] <= newInterval[1] ){
            //min = Math.min(intervals[i][0], newInterval[0]);
            //max = Math.max(intervals[i][1], newInterval[1]);
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        list.add(new int[]{newInterval[0], newInterval[1]});
        //list.add(new int[]{min, max});
        
        //condition 3: parter bybond overlap
        while (i < intervals.length){
            list.add(new int[] {intervals[i][0], intervals[i][1]});
            i++;
        }
        
        int[][]result = new int[list.size()][2];
        for(int j = 0; j <list.size(); j ++){
            result[j][0] = list.get(j)[0];
            result[j][1] = list.get(j)[1];
        }
        return result; 
        
        
    }
    
}
