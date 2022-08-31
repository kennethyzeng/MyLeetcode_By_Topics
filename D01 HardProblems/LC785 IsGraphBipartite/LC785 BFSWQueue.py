###BFS with Queue solution
from collections import deque
class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:

        colors = {}

        for from_node in range(len(graph)):
            if from_node in colors:
                continue
            queue = deque([from_node])
            colors[from_node] = 1 # 1 is just starting color, could be -1 also

            while queue:
                from_node = queue.popleft()
                for to_node in graph[from_node]:
                    if to_node in colors:
                        if colors[to_node] == colors[from_node]:
                            return False
                    else:
                        queue.append(to_node)
                        colors[to_node] = colors[from_node] * -1

        return True