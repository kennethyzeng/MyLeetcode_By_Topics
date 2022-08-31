/*

*/ 

public int minMeetinRooms(int[][] intervals){
    Arrays.sort(interval, (int[]a, int[]b) ->a[0] - b[0]);
    PriorityQueue<Integer> minHeap = new PriorityQueu<>((a,b)->a-b); 
    minHeap.add(intervals[0][1]);

    for(int i = 1; i < intervals.length;i ++ ){
        if(interval[i][0] > minHeap.peek()){
            minHeap.poll();
        }else{
            minHeap.add(interval[i][1]);
        }
    }
    return minHeap.size();
}
