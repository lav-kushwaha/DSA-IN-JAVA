package _30_Graph_Theory._05_ShortestPath_Algorithm.BellmanFord_Algorithm;

import java.util.*;

//https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1
//Bellman-Ford
class BellmanFordAlgorithm {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        int INF = (int) 1e8; //Integer.MAX_VALUE

        Arrays.fill(dist, INF);
        dist[src] = 0;

        // Relax all edges V - 1 times
        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if (dist[u] != INF && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // Check for negative-weight cycles
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            if (dist[u] != INF && dist[u] + wt < dist[v]) {
                return new int[]{-1};
            }
        }

        // Optional: convert unreachable distances to -1
        for (int i = 0; i < V; i++) {
            if (dist[i] == INF) dist[i] = -1;
        }

        return dist;
    }
    public static void main(String[] args) {
        int V = 6;
        int S = 0;

        int[][] edges = {
                {3, 2, 6},
                {5, 3, 1},
                {0, 1, 5},
                {1, 5, -3},
                {1, 2, -2},
                {3, 4, -2},
                {2, 4, 3}
        };

        BellmanFordAlgorithm sol = new BellmanFordAlgorithm();
        int[] dist = sol.bellmanFord(V, edges, S);

        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }
}

