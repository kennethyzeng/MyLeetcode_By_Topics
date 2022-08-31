/*
 sort O(NlogN), minimum heap O(NlogN) and maximum heap O(NlogK)
*/ 

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((b,a)->a[0]*a[0] + a[1]*a[1] - b[0]*b[0]-b[1]*b[1]);
        
        for(int[] point : points){
            maxHeap.add(point);
            if(maxHeap.size() > k)
                maxHeap.poll();
        }
        
        for(int i = 0; i < k; i++){
            res[i] =maxHeap.poll();
        }
        return res;
    }
}
