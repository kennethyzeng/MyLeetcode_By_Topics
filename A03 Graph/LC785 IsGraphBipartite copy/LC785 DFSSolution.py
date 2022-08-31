###DFS solution
class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        colors = {}
        for node_from in range(len(graph)):
            if node_from not in colors and not self.dfs(graph, node_from, colors, 1):
                return False

        return True

    def dfs(self, graph, node, colors, color):

        colors[node] = color

        for node_to in graph[node]:
            if node_to in colors:
                if colors[node_to] == colors[node]:
                    return False
            else:
                if not self.dfs(graph, node_to, colors, color * -1):
                    return False

        return True