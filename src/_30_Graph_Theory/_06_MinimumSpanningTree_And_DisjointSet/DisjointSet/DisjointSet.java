package _30_Graph_Theory._06_MinimumSpanningTree_And_DisjointSet.DisjointSet;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);       // Initialize rank to 0
            parent.add(i);     // Initially, every node is its own parent
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp); // Path compression
        return ulp;
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v) return;

        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);  // attach smaller rank tree under bigger one
        } else {
            parent.set(ulp_v, ulp_u);  // Make one root of the other
            rank.set(ulp_u, rank.get(ulp_u) + 1); // Increase rank
        }
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        // Check if 3 and 7 belong to the same set
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not same");
        }

        // Union sets containing 3 and 7
        ds.unionByRank(3, 7);

        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not same");
        }
    }
}
