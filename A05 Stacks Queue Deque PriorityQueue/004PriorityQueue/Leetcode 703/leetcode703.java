/*

TC --> O(nlogn)  or O(Nlogk)   due to priorityqueu. sorted
SC --> O(n) because priorityQueue take space
*/ 

class KthLargest {
    PriorityQueue<Integer> minHeap; 
    int k; 
    
    public KthLargest(int k, int[] nums) {
        this.k = k;                     //this k is from line 9; k is from parameter
        minHeap = new PriorityQueue<>(k); 
        for(int n : nums){
            add(n);
        }
    }
    
    public int add(int val) {
        if(minHeap.size() < k){      //if Minheap don't have enough element, add
            minHeap.offer(val);
        } else if (minHeap.peek() < val){    //compare and add if bigger
            minHeap.poll(); 
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
