package _30_Graph_Theory._06_MinimumSpanningTree_And_DisjointSet.Questions;

import java.util.*;

class DisjointtSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    // Constructor: initializes rank, parent, and size for each node
    public DisjointtSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);  // Each node is its own parent initially
            size.add(1);    // Each set has size 1 initially
        }
    }

    // Find with path compression
    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp); // Path compression
        return ulp;
    }

    // Union by rank (not used here but implemented)
    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;

        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank.get(ulp_u) + 1);
        }
    }

    // Union by size (used in the island merging logic)
    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;

        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

public class NumberOfIslands {

    // Checks whether given cell is within grid bounds
    private boolean isValid(int adjr, int adjc, int n, int m) {
        return adjr >= 0 && adjr < n && adjc >= 0 && adjc < m;
    }

    public List<Integer> numOfIslands(int n, int m, int[][] operators) {
        DisjointtSet ds = new DisjointtSet(n * m);  // DSU for n*m cells
        int[][] vis = new int[n][m];  // Visited matrix to mark land
        int cnt = 0;  // Count of current islands
        List<Integer> ans = new ArrayList<>();

        int len = operators.length;
        for (int i = 0; i < len; i++) {
            int row = operators[i][0];
            int col = operators[i][1];

            // If already land, just record the current island count
            if (vis[row][col] == 1) {
                ans.add(cnt);
                continue;
            }

            vis[row][col] = 1;  // Mark the cell as land
            cnt++;              // New land creates a new island

            // Directions: up, right, down, left
            int[] dr = {-1, 0, 1, 0};
            int[] dc = {0, 1, 0, -1};

            for (int ind = 0; ind < 4; ind++) {
                int adjr = row + dr[ind];
                int adjc = col + dc[ind];

                // Check valid neighbor and if it's already land
                if (isValid(adjr, adjc, n, m) && vis[adjr][adjc] == 1) {
                    int nodeNo = row * m + col;           // Flatten 2D -> 1D
                    int adjNodeNo = adjr * m + adjc;

                    // If neighbor is from a different island, merge them
                    if (ds.findUPar(nodeNo) != ds.findUPar(adjNodeNo)) {
                        cnt--;  // Two islands become one
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }

            ans.add(cnt);  // Record current island count
        }

        return ans;
    }

    // Main method for simple test
    public static void main(String[] args) {
        NumberOfIslands obj = new NumberOfIslands();

        int n = 4, m = 5;
        int[][] operators = {
                {1, 1},
                {0, 1},
                {3, 3},
                {3, 4}
        };

        List<Integer> result = obj.numOfIslands(n, m, operators);
        System.out.println(result); // Expected: [1, 1, 2, 2]
    }
}
