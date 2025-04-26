package _30_Graph_Theory.Graph_Traversals.Questions.DFS;

import java.util.*;

//https://www.geeksforgeeks.org/problems/bipartite-graph/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
//Bipartite Graph using dfs
class BipartiteGraph {
    public boolean isBipartite(ArrayList<ArrayList<Integer>> adj) {
        int v = adj.size();
        int[] color = new int[v];
        Arrays.fill(color, -1); // Initialize all nodes as uncolored (-1)

        // Check for all components (to handle disconnected graphs)
        for (int i = 0; i < v; i++) {
            if (color[i] == -1) { // If not colored, start DFS
                if (!checkBipartiteDFS(i, 0, color, adj)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkBipartiteDFS(int node, int col, int[] color, ArrayList<ArrayList<Integer>> adj) {
        color[node] = col; // Assign color (0 or 1)

        for (int neighbor : adj.get(node)) {
            if (color[neighbor] == -1) { // If uncolored, assign opposite color and DFS further
                if (!checkBipartiteDFS(neighbor, 1 - col, color, adj)) {
                    return false;
                }
            } else if (color[neighbor] == color[node]) { // If neighbor has the same color, not bipartite
                return false;
            }
        }
        return true;
    }

    // Driver Code
    public static void main(String[] args) {
        BipartiteGraph bg = new BipartiteGraph();
        int vertices = 4;
        
        // Creating adjacency list representation of a graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges (Example: Bipartite graph)
        adj.get(0).add(1);
        adj.get(1).add(0);
        
        adj.get(1).add(2);
        adj.get(2).add(1);
        
        adj.get(2).add(3);
        adj.get(3).add(2);
        
        adj.get(3).add(0);
        adj.get(0).add(3);

        boolean result = bg.isBipartite(adj);
        System.out.println("Is the graph bipartite? " + result);
    }
}

//Time Complexity	O(V + E) (DFS visits each node and edge once)
//Space Complexity	O(V + E) (Adjacency list + recursion stack + color array)