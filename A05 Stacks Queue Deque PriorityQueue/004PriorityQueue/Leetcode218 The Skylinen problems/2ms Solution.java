/*
Runtime: 2 ms, faster than 100.00% of Java online submissions for The Skyline Problem.
Memory Usage: 42.5 MB, less than 60.41% of Java online submissions for The Skyline Problem.
*/ 
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> builds = new PriorityQueue<>((a, b) -> b[2] - a[2]);  
        int next = 0;
        int[] cur = null;
        
        while (cur != null || next < buildings.length) {
            if (cur == null) {
                cur = buildings[next];
                addPoint(res, cur[0], cur[2]);
            } else if (next < buildings.length && buildings[next][0] <= cur[1]) {
                if (buildings[next][2] > cur[2]) {
                    if (buildings[next][0] == cur[0])
                        res.remove(res.size() - 1);
                    if (buildings[next][1] <= cur[1])
                        builds.add(cur);                
                    cur = buildings[next];
                    addPoint(res, cur[0], cur[2]);
                } else if (buildings[next][1] > cur[1])
                    builds.add(buildings[next]);
                next++;
            } else {
                int[] lower = builds.poll();
                while (lower != null && lower[1] <= cur[1])
                    lower = builds.poll();
                if (lower == null)
                    addPoint(res, cur[1], 0);
                else if(lower[2] < cur[2])
                    addPoint(res, cur[1], lower[2]);
                cur = lower;
            }
        }
        return res;
    }
    
    private void addPoint(List<List<Integer>> res, int p, int h){
        List<Integer> tmp = new ArrayList<>();
        tmp.add(p);
        tmp.add(h);
        res.add(tmp);
    }
}