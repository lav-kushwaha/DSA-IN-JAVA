package _30_Graph_Theory._06_MinimumSpanningTree_And_DisjointSet;

import java.util.*;

//https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimum-spanning-tree
//Minimum Spanning Tree

//Complexity
// Time Complexity	O((V + E) log V)
// Space Complexity	O(V + E)
public class PrimsAlgorithm_MinimumSpanningTree {

    static class Node {
        int node;
        int dis;

        Node(int node, int dis) {
            this.node = node;
            this.dis = dis;
        }
    }

    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.dis - b.dis);
        pq.add(new Node(0, 0));

        int sum = 0;
        int[] vis = new int[V];
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int currnode = curr.node;
            int currdis = curr.dis;

            if (vis[currnode] == 1) continue;

            vis[currnode] = 1;
            sum = sum + currdis;

            for (int i = 0; i < adj.get(currnode).size(); i++) {
                int[] edge = adj.get(currnode).get(i);
                int neighbour = edge[0];
                int edgewt = edge[1];

                if (vis[neighbour] == 0) {
                    pq.add(new Node(neighbour, edgewt));
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int E = 6; // Number of edges

        // Build adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Example graph: (u, v, weight)
        int[][] edges = {
            {0, 1, 2},
            {0, 3, 6},
            {1, 2, 3},
            {1, 3, 8},
            {1, 4, 5},
            {2, 4, 7}
        };

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt}); // because the graph is undirected
        }

        int totalWeight = spanningTree(V, E, adj);
        System.out.println("Minimum Spanning Tree Total Weight: " + totalWeight);
    }
}


//Imagine if adj looks like this for a simple graph:
//
//        Node 0: [ [1, 2], [3, 6] ]
//        Node 1: [ [0, 2], [2, 3], [3, 8], [4, 5] ]
//        adj.get(0) gives: [ [1,2], [3,6] ]
//        adj.get(0).get(0) gives: [1,2] (neighbor 1, weight 2)
//        adj.get(0).get(1) gives: [3,6] (neighbor 3, weight 6)


