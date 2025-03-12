package _30_Graph_Theory.Questions.BFS;

import java.util.*;

class BipartiteGraph {
    public boolean isBipartite(ArrayList<ArrayList<Integer>> adj) {
        int v = adj.size();
        int color[] = new int[v];
        Arrays.fill(color, -1); // Initialize all nodes as uncolored (-1)

        // Check for all components in case the graph is disconnected
        for (int i = 0; i < v; i++) {
            if (color[i] == -1) { // Only check unvisited components
                if (!checkBipartiteBFS(i, color, adj)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkBipartiteBFS(int start, int[] color, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 0; // Start coloring with 0

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : adj.get(node)) {
                if (color[neighbor] == -1) { // If unvisited, assign opposite color
                    color[neighbor] = 1 - color[node];
                    queue.add(neighbor);
                } else if (color[neighbor] == color[node]) { // If same color as parent, not bipartite
                    return false;
                }
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
