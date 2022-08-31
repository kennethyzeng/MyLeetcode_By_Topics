/*
Time Complexity: NlogN because sorting
Space Complexity:

*/ 

class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length; 
        PriorityQueue<int[]> maxpq= new PriorityQueue<>((a,b)->b[1]-a[1]);
        
        for (int i = 0; i < n; i ++){
            maxpq.offer(new int[] {i, nums2[i] });  //store index and value of array
        }
        
        Arrays.sort(nums1); 
        int l = 0, r = n -1 ;
        int[] res = new int[n];
        
        while(!maxpq.isEmpty()){
            int[] pair = maxpq.poll(); 
            if (nums1[r] > pair[1]){
                res[pair[0]] = nums1[r];
                r --;
            } else{
                res[pair[0]] = nums1[l];
                l ++;
            }
        }
        return res; 
    }
}
