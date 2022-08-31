/*
Runtime: 11 ms, faster than 30.75% of Java online submissions for Course Schedule.
Memory Usage: 45 MB, less than 30.48% of Java online submissions for Course Schedule.

*/ 

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses]; 
        HashMap<Integer, List<Integer>> graph = new HashMap<>(); 
        
        //Step 1 Create HashMap
        for(int i = 0; i < prerequisites.length; i ++){
            //to-take: prerequisites[i][0]   value in HashMap        int[][] a = prerequisites[i][0]
            //prerequisite: prerequisites[i][1]   key in HashMap     int[][] b = prerequisites[i][1]
            inDegree[prerequisites[i][0]]++;  //count time of "to-take" for in inDegree 
            if (graph.containsKey(prerequisites[i][1])) {  
                graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }else{
                ArrayList<Integer> list = new ArrayList<>(); 
                list.add(prerequisites[i][0]); 
                graph.put(prerequisites[i][1], list); 
            }
        }
        
        //Step 2 
        Queue<Integer> queue = new LinkedList<>(); 
        for(int i = 0;  i < numCourses; i++){
            if(inDegree[i] ==0) queue.add(i); 
        }
        
        //Step 3
        while(!queue.isEmpty()){
            int cur = queue.poll();
            List<Integer> toTake = graph.get(cur);   //get the values of cur key in hashmap graph
            //get corresponding Hashmap values for queue.poll(above); toTake is (4)->(3)-> for key 1
            for (int i =0; toTake!= null && i < toTake.size(); i ++){
                inDegree[toTake.get(i)] --; 
                if(inDegree[toTake.get(i)] == 0) queue.add(toTake.get(i));
            }
        }
        
        //Step 4: 
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] != 0) return false;
        }
        return true;
    }
}
