package _30_Graph_Theory._06_MinimumSpanningTree_And_DisjointSet.DisjointSet;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {

    // Stores the parent of each node
    List<Integer> parent = new ArrayList<>();

    // Used for union by rank
    List<Integer> rank = new ArrayList<>();

    // Used for union by size
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i); // Initially, each node is its own parent
            rank.add(0);   // Rank is 0 for all nodes at the start
            size.add(1);   // Size is 1 for each individual node
        }
    }

    // Find the ultimate parent of a node with path compression
    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node; // If node is its own parent, return it
        }
        // Recursively find the top parent and compress the path
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return ulp;
    }

    // Union by Rank: attach smaller rank tree under the bigger one
    //Union operation works on set representatives.
    //You only want to merge two different sets if they have different ultimate parents.
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

    // Union by Size: attach smaller tree under the larger one
    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u); // Ultimate parent of u
        int ulp_v = findUPar(v); // Ultimate parent of v

        if (ulp_u == ulp_v) return; // Already in same set

        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v); // u joins v's tree
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u)); // Update size
        } else {
            parent.set(ulp_v, ulp_u); // v joins u's tree
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v)); // Update size
        }
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7); // Nodes 0 to 7
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        // Check if 3 and 7 are in the same set
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not same");
        }

        // Connect sets containing 3 and 7
        ds.unionByRank(3, 7);

        // Check again
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not same");
        }
    }
}
