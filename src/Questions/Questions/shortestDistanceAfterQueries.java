package Questions.Questions;
import java.util.*;

//Approach (Using BFS (edges are unweighted)
//T.C : O(q * (E log(V)) , V = number of vertices and E = number of edges
//S.C : O(V+E)

//https://leetcode.com/problems/shortest-distance-after-road-addition-queries-i/description/
//3243. Shortest Distance After Road Addition Queries I
class shortestDistanceAfterQueries {
    private Map<Integer, List<Integer>> adj = new HashMap<>();

    private int bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(0);
        visited[0] = true;

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int node = queue.poll();

                if (node == n - 1) {
                    return level; // Found the destination node
                }

                for (int neighbor : adj.getOrDefault(node, new ArrayList<>())) {
                    if (!visited[neighbor]) {
                        queue.offer(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
            level++;
        }
        return -1; // If destination node is unreachable
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        adj.clear();

        // Initialize adjacency list with direct edges (i -> i + 1)
        for (int i = 0; i < n - 1; i++) {
            adj.computeIfAbsent(i, k -> new ArrayList<>()).add(i + 1);
        }

        int k = queries.length;
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            adj.computeIfAbsent(u, k1 -> new ArrayList<>()).add(v);
            res[i] = bfs(n);
        }

        return res;
    }
}