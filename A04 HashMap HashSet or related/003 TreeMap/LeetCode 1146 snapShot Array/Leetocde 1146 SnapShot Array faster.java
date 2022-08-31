/*
Time Complexity:
Space Complexity:
18 ms

*/ 



class SnapshotArray {

    int len;
    List<int[]> shot;
    int[] list;
    int snapId;
    int maxlen;
    
    public SnapshotArray(int length) {
        list = new int[length];
        shot = new ArrayList<>();
        len = length;
        snapId = 0;
        maxlen = 0;
    }
    
    public void set(int index, int val) {
            list[index] = val;
            maxlen = Math.max(maxlen, index);
        
    }
    
    public int snap() {
        shot.add(Arrays.copyOf(list, maxlen + 1));
        snapId++;
        return snapId - 1;
    }
    
    public int get(int index, int snap_id) {
        int[] shotArray = shot.get(snap_id);
        if (index >= shotArray.length)
            return 0;
        return shotArray[index];
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */