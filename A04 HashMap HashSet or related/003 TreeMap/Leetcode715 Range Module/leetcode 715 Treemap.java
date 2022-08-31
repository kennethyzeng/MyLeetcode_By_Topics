/*
Runtime: 86 ms, faster than 26.95% of Java online submissions for Range Module.
Memory Usage: 80.2 MB, less than 36.43% of Java online submissions for Range Module.

*/ 


class RangeModule {
    TreeMap<Integer, Integer> map; 
    public RangeModule() {
        map = new TreeMap<>();
    }
    
    public void addRange(int left, int right) {		//left : index   right: value of treemap
        if (left >= right) return; 
        Integer start = map.floorKey(left); 
        if (start == null) start = map.ceilingKey(left); 
        while (start != null && start <= right){
            int end = map.get(start); 
			//check if overlap. is so , remove the old interval, anc combine to create new one
            if (end >= left) {			
                map.remove(start); 
                if (start < left) left = start; 
                if (end > right) right = end; 
            }
            start = map.ceilingKey(end); 
        }
        map.put(left, right); 
    }
    
    public boolean queryRange(int left, int right) {
        Integer floor = map.floorKey(left); 
        return floor != null && map.get(floor) >= right; 
    }
    
    public void removeRange(int left, int right) {
        if (left >= right) return; 
        Integer start = map.floorKey(left); 
        if (start == null) start = map.ceilingKey(left); 
        while (start != null && start <= right){
            int end = map.get(start); 
            if (end >= left) {
                map.remove(start); 
                if (start < left) map.put(start, left); 
                if (end > right) map.put(right, end);
            }
            start = map.ceilingKey(end);
        }
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */