package _30_Graph_Theory._06_MinimumSpanningTree_And_DisjointSet.Questions;

import java.util.*;

//https://www.geeksforgeeks.org/problems/connected-components-in-an-undirected-graph/1
//https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/
//Connected Components in an Undirected Graph
class ConnectedComponentsInAnUndirectedGraph {
    public ArrayList<ArrayList<Integer>> getComponents(int n, int[][] edges) {
        DisjointSet ds = new DisjointSet(n);

        for (int[] edge : edges) {
            ds.union(edge[0], edge[1]);
        }

        Map<Integer, ArrayList<Integer>> components = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = ds.findParent(i);
            components.putIfAbsent(root, new ArrayList<>());
            components.get(root).add(i);
        }

        return new ArrayList<>(components.values());
    }
}
class DisjointSet {
    List<Integer> parent;
    List<Integer> size;

    // Initialize parent and size arrays
    public DisjointSet(int n) {
        parent = new ArrayList<>();
        size = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            parent.add(i);     // Each node is its own parent
            size.add(1);       // Initial size of each set is 1
        }
    }

    // Find the ultimate parent with path compression
    public int findParent(int node) {
        if (parent.get(node) == node) return node;
        int root = findParent(parent.get(node));
        parent.set(node, root);
        return root;
    }

    // Union two sets by size
    public void union(int u, int v) {
        int rootU = findParent(u);
        int rootV = findParent(v);

        if (rootU == rootV) return;  // Already connected

        // Attach smaller tree under larger one
        if (size.get(rootU) < size.get(rootV)) {
            parent.set(rootU, rootV);
            size.set(rootV, size.get(rootV) + size.get(rootU));
        } else {
            parent.set(rootV, rootU);
            size.set(rootU, size.get(rootU) + size.get(rootV));
        }
    }
}

