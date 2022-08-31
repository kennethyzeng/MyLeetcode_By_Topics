/*


*/ 

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (0 == n) return Collections.emptyList();
        if (1 == n) return Arrays.asList(0);
        if (2 == n) return Arrays.asList(0, 1);
        int[] deg = new int[n], adj = new int[n];
        for (int[] e : edges) {
            int i = e[0], j = e[1];
            deg[i]++;
            deg[j]++;
            adj[i] ^= j;
            adj[j] ^= i;
        }
        LinkedList<Integer> q = new LinkedList();
        for (int i = 0; i < n; ++i) if (1 == deg[i]) q.add(i);
        while (2 < n) {
            int size = q.size();
            n -= size;
            while (0 < size--) {
                int i = q.poll(), j = adj[i];
                adj[j] ^= i;
                if (1 == --deg[j]) q.add(j);
            }
        }
        return q;
    }
}