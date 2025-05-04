package _30_Graph_Theory._06_MinimumSpanningTree_And_DisjointSet.Kruskals_Algorithm;

import java.util.*;

// Disjoint Set (Union-Find) with union by size and path compression
class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i); // Each node is its own parent initially
            size.add(1);   // Size of each set is 1 initially
        }
    }

    // Find with path compression
    public int findUPar(int node) {
        if (node == parent.get(node)) return node;

        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp); // Path compression
        return ulp;
    }

    // Union by size
    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v) return; // Already in the same set

        // Attach smaller set to larger set
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u); // Ultimate parent of u
        int ulp_v = findUPar(v); // Ultimate parent of v

        if (ulp_u == ulp_v) return; // Already in same set

        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v); // u joins v's tree
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u); // v joins u's tree
        } else {
            parent.set(ulp_u, ulp_v); // Make v parent of u
            rank.set(ulp_v, rank.get(ulp_v) + 1); // Increase rank of new root
        }
    }
}

// Edge class with comparable to sort by weight
class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int src, int dest, int wt) {
        this.src = src;
        this.dest = dest;
        this.weight = wt;
    }

    // Used to sort edges by weight in ascending order
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

public class KrushkalAlgorithm {

    // Kruskal's algorithm to find the weight of the Minimum Spanning Tree
    public static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        List<Edge> edges = new ArrayList<>();

        // Convert adjacency list to edge list
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int adjNode = adj.get(i).get(j).get(0);
                int wt = adj.get(i).get(j).get(1);

                // To avoid adding both (u,v) and (v,u) in undirected graph
                if (i < adjNode) {
                    edges.add(new Edge(i, adjNode, wt));
                }
            }
        }

        // Sort edges by weight using compareTo()
        Collections.sort(edges);

        // Initialize Disjoint Set
        DisjointSet ds = new DisjointSet(V);
        int mstWt = 0;

        // Pick the smallest edge, and add it if it doesn't form a cycle
        for (Edge e : edges) {
            int u = e.src;
            int v = e.dest;
            int wt = e.weight;

            // Check if u and v belong to different sets (no cycle)
            if (ds.findUPar(u) != ds.findUPar(v)) {
                mstWt += wt;            // Add edge weight to total
                ds.unionBySize(u, v);   // Union the sets
            }
        }

        return mstWt; // Total weight of MST
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices

        // Adjacency list representation of the graph
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        int[][] edges = {
                {0, 1, 2},
                {0, 2, 1},
                {1, 2, 1},
                {2, 3, 2},
                {3, 4, 1},
                {4, 2, 2}
        };

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the adjacency list from the edges
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];

            ArrayList<Integer> tmp1 = new ArrayList<>();
            ArrayList<Integer> tmp2 = new ArrayList<>();

            tmp1.add(v);
            tmp1.add(w);

            tmp2.add(u);
            tmp2.add(w);

            adj.get(u).add(tmp1);
            adj.get(v).add(tmp2);
        }

        // Run Kruskal's algorithm
        int mstWt = spanningTree(V, adj);
        System.out.println("The sum of all the edge weights in MST: " + mstWt);
    }
}


/**
the adj list will look like this (before Kruskal):
 * adj.get(0) = [[1, 2], [2, 1]]
 * adj.get(1) = [[0, 2], [3, 3]]
 * adj.get(2) = [[0, 1]]
 * adj.get(3) = [[1, 3]]
 */
