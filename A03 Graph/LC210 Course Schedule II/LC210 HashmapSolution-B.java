Topological Sort is Easy -- The General Template
*
What we need ?
1. HashMap<Node, Indegree> inDegree: A in-degree map, which record each nodes in-degree.
2. HashMap<Node, List<Node>children> topoMap: A topo-map which record the Node's children

What we do ?
1. Init: Init the two HashMaps.
2. Build Map: Put the child into parent's list ; Increase child's in-degree by 1.
3. Find Node with 0 in-degree: Iterate the inDegree map, find the Node has 0 inDegree. (If none, there must be a circle)
4. Decrease the children's inDegree by 1: Decrease step3's children's inDegree by 1.
5. Remove this Node: Remove step3's Node from inDegree. Break current iteration.
6. Do 3-5 until inDegree is Empty: Use a while loop

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Topological sort
        // Edge case
        if(numCourses <= 0) return new int[0];
        
        //1. Init Map
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, List<Integer>> topoMap = new HashMap<>();
        for(int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
            topoMap.put(i, new ArrayList<Integer>());
        }
        
        //2. Build Map
        for(int[] pair : prerequisites) {
            int curCourse = pair[0], preCourse = pair[1];
            topoMap.get(preCourse).add(curCourse);  // put the child into it's parent's list
            inDegree.put(curCourse, inDegree.get(curCourse) + 1); // increase child inDegree by 1
        }
        //3. find course with 0 indegree, minus one to its children's indegree, until all indegree is 0
        int[] res = new int[numCourses];
        int base = 0;
        while(!inDegree.isEmpty()) {
            boolean flag = false;   // use to check whether there is cycle
            for(int key : inDegree.keySet()) {  // find nodes with 0 indegree
                if(inDegree.get(key) == 0) {
                    res[base ++] = key;
                    List<Integer> children = topoMap.get(key);  // get the node's children, and minus their inDegree
                    for(int child : children) 
                        inDegree.put(child, inDegree.get(child) - 1);
                    inDegree.remove(key);      // remove the current node with 0 degree and start over
                    flag = true;
                    break;
                }
            }
            if(!flag)  // there is a circle --> All Indegree are not 0
                return new int[0];
        }
        return res;
    }
}