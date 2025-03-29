package _30_Graph_Theory.ShortestPath_Algorithm.Questions;

import java.util.*;
import java.lang.*;
import java.io.*;

//https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-path-in-undirected-graph
//Shortest path in Directed Acyclic Graph
class ShortestPathInDAG {

    public static void main(String[] args) throws IOException {
        int n = 6, m = 7;
        int[][] edge = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        ShortestPathInDAG obj = new ShortestPathInDAG();
        int res[] = obj.shortestPath(n, m, edge);
//        for (int i = 0; i < n; i++) {
//            System.out.print(res[i] + " ");
//        }
//        System.out.println();
    }

    static class Pair {
        int first, second;
        Pair(int _first, int _second) {
            this.first = _first;
            this.second = _second;
        }

        //To print adj list we have override toString.
//        @Override
//        public String toString() {
//            return "(" + first + ", " + second + ")";
//        }
    }

    private void topoSort(int node, ArrayList<ArrayList<Pair>> adj, int vis[], Stack<Integer> st) {
        vis[node] = 1;
        for (Pair it : adj.get(node)) {
            int v = it.first;
            if (vis[v] == 0) {
                topoSort(v, adj, vis, st);
            }
        }
        st.push(node);
    }

    public int[] shortestPath(int N, int M, int[][] edges) {
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

        //printing adj list.
//        for (int i = 0; i < adj.size(); i++) {
//            System.out.print("List " + i + ": ");
//            for (Pair p : adj.get(i)) {
//                System.out.print(p + " ");
//            }
//            System.out.println();
//        }


        int vis[] = new int[N];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (vis[i] == 0) {
                topoSort(i, adj, vis, st);
            }
        }
        System.out.println(st);

        int dist[] = new int[N];
        Arrays.fill(dist, (int)(1e9));
        dist[0] = 0;

        while (!st.isEmpty()) {
            int node = st.pop();
            if (dist[node] != (int)(1e9)) {
                for (Pair it : adj.get(node)) {
                    int v = it.first;
                    int wt = it.second;
                    if (dist[node] + wt < dist[v]) {
                        dist[v] = dist[node] + wt;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (dist[i] == (int)(1e9)) dist[i] = -1;
        }
        return dist;
    }
}