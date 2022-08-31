/*


*/ 


class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return intervals; 
        
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (int[]a, int[]b) -> a[0] - b[0]);  //ascending sorting for two-Dimension Arrays
        result.add(intervals[0]);
        for(int i = 1; i < intervals.length; i ++){
            int[] lastArray = result.get(result.size() -1);  //last element in result
            if(lastArray[1] >= intervals[i][0]){
                lastArray[1] = Math.max(lastArray[1], intervals[i][1]);   //checking the overlapping part
            }else{
                result.add(intervals[i]);
            }
        }
        return result.toArray(new int[result.size() -1][2]);   //also size of two d array
        
    }
}