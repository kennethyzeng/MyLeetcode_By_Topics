// 1ms solution


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        /*
                            DFS ATTEMPT (using backtracking)
        */
        // create a new array representing the graph- courses and prereqs, visited and dp (similar to visited)
        ArrayList[] graph = new ArrayList[numCourses];
        boolean[] visited = new boolean[numCourses];
        boolean[] dp = new boolean[numCourses];
        
        // create a new list for every course
        for(int i=0;i<numCourses;i++) {
            graph[i] = new ArrayList();
        }
        // populate the list for each course with the prereqs
        for(int i=0; i<prerequisites.length;i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        // finally iterate through all courses with dfs helper
        for(int i=0; i<numCourses; i++){
            if(!dfs(graph,visited,i, dp)) {
                return false;
            }
        }
        return true;
}
    
    public boolean dfs(ArrayList[] graph, boolean[] visited, int course, boolean[] dp) {
        // if we already visited, return dp's value which gets set below
        if (visited[course]) {
            return dp[course];
        }
        else {
            visited[course] = true;
        }
        
        // iterate through all of course's prereqs
        for (int i = 0; i < graph[course].size(); i++) {
            int nextCourse = (int)graph[course].get(i);
            if (!dfs(graph, visited, nextCourse, dp)) {
                // save value into DP so if we see it again, we can return it above. this saves us having to go into a long branch if we've
                // already seen the node before
                dp[course] = false;
                return false;
            }
        }
        // if dfs finished successfully for this course, set DP's value so we can reduce calculations
        dp[course] = true;
        return true;
    }
    
    
   