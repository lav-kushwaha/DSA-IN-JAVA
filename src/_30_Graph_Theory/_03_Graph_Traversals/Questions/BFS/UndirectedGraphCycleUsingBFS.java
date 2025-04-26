package _30_Graph_Theory._03_Graph_Traversals.Questions.BFS;

import java.util.*;

//https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/
//Cycle Detection in unirected Graph (bfs)
class UndirectedGraphCycleUsingBFS {
    public static boolean isCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) { 
                if (bfsCheckCycle(i, adj, visited)) return true;
            }
        }
        return false;
    }

    private static boolean bfsCheckCycle(int start, List<List<Integer>> adj, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, -1});  // (node, parent)
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0], parent = current[1];

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new int[]{neighbor, node});
                } else if (neighbor != parent) {  
                    return true;  // Cycle found
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(Arrays.asList(1)); // 0
        adj.add(Arrays.asList(0, 2, 4)); // 1
        adj.add(Arrays.asList(1, 3)); // 2
        adj.add(Arrays.asList(2, 4)); // 3
        adj.add(Arrays.asList(1, 3)); // 4

        System.out.println(isCycle(adj.size(), adj) ? 1 : 0);
    }
}
