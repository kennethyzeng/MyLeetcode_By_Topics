###########
Time Complexity:  Complexity is O(V+E), because we traverse our graph only once.
Space Complexity:


#############
class Solution:
    def dfs(self, start):
        self.visited[start] = 1
        for neib in self.adj[start]:
            if self.visited[neib[0]] == 0:
                if neib[1] == 1:
                    self.count += 1
                self.dfs(neib[0])
    
    def minReorder(self, n, connections):
        self.visited = [0] * n
        self.adj = defaultdict(list) 
        self.count = 0
        for i, j in connections:
            self.adj[i].append([j,1])
            self.adj[j].append([i,-1])

        self.dfs(0)
        return self.count