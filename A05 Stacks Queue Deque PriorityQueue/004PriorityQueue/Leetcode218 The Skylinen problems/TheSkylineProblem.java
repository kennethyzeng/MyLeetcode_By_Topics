/*
Runtime: 197 ms, faster than 30.92% of Java online submissions for The Skyline Problem.
Memory Usage: 42.2 MB, less than 77.86% of Java online submissions for The Skyline Problem.
*/ 

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> list = new ArrayList<>(); 
        List<int[]> buildLines = new ArrayList<>();
        
        for (int[] point : buildings ){
            buildLines.add(new int[] {point[0], -point[2]});
            buildLines.add(new int[] {point[1], point[2]});
        }
        
        Collections.sort(buildLines, (a, b)->{
           if (a[0] != b[0]) {return a[0] - b[0];}
            else {return a[1] - b[1];}
        });
            
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);  
        int preHighest = 0; 
        maxHeap.add(0); 
        for(int[] point : buildLines){
            if(point[1] < 0){
                maxHeap.add(-point[1]);
            }else{
                maxHeap.remove(point[1]);
            }
            int curHeight = maxHeap.peek(); 
            if(curHeight != preHighest){
                list.add(Arrays.asList(point[0], curHeight)); 
                preHighest = curHeight;
            }
        }
        return list; 
        
    }
}