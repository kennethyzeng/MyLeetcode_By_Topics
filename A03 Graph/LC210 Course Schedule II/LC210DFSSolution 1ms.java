// 1ms solution

class Solution {
    public int res[],count=0;
    public boolean isCycle(int cur,ArrayList<Integer> graph[],int visited[]){
        if(visited[cur]==2)
            return true;
        visited[cur]=2;
        for(int i=0;i<graph[cur].size();i++){
            if(visited[graph[cur].get(i)]!=1){
                if(isCycle(graph[cur].get(i),graph,visited))
                    return true;
            }
        }
        res[count++]=cur;
        visited[cur]=1;
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        res=new int[numCourses];
        int visited[]=new int[numCourses];
        ArrayList<Integer> graph[]=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            graph[i]=new ArrayList<Integer>();
        for(int i=0;i<prerequisites.length;i++){
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        for(int i=0;i<numCourses;i++){
            if(visited[i]!=1){
                if(isCycle(i,graph,visited))
                    return new int[0];
            }
        }
        return res;
    }
}