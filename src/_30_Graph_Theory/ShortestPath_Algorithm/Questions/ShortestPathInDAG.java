package _30_Graph_Theory.ShortestPath_Algorithm.Questions;

import java.util.*;

//https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-path-in-undirected-graph
//Shortest Path in a Directed Acyclic Graph (DAG) using Topological Sorting + Relaxation
class ShortestPathInDAG {

    public static void main(String[] args) {
        int n = 6, m = 7;
        int[][] edge = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        ShortestPathInDAG obj = new ShortestPathInDAG();
        int res[] = obj.shortestPath(n, m, edge, 0);  // Source = 0 start from node 0.

        System.out.println("Shortest distances: " + Arrays.toString(res));
    }

    static class Pair {
        int first, second;
        Pair(int _first, int _second) {
            this.first = _first;
            this.second = _second;
        }
    }

    private void topoSort(int node, ArrayList<ArrayList<Pair>> adj, boolean vis[], Stack<Integer> st) {
        vis[node] = true;
        for (Pair it : adj.get(node)) {
            int v = it.first;
            if (!vis[v]) {
                topoSort(v, adj, vis, st);
            }
        }
        st.push(node);
    }

    public int[] shortestPath(int N, int M, int[][] edges, int src) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        // Building adjacency list
        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }

        // Topological Sort using DFS
        boolean vis[] = new boolean[N];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                topoSort(i, adj, vis, st);
            }
        }

        // Print Topological Order (For Debugging)
        System.out.print("Topological Order: ");
        for (Integer node : st) {
            System.out.print(node + " ");
        }
        System.out.println();

        // Initialize distances
        int dist[] = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0; //src node dist initially 0

        // Relax edges in Topological Order
        while (!st.isEmpty()) {
            int node = st.pop();
            if (dist[node] != Integer.MAX_VALUE) {
                for (Pair it : adj.get(node)) {
                    int v = it.first;
                    int wt = it.second;
                    if (dist[node] + wt < dist[v]) {
                        dist[v] = dist[node] + wt;
                    }
                }
            }
        }

        // Convert unreachable distances to -1
        for (int i = 0; i < N; i++) {
            if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }

        return dist;
    }
}
