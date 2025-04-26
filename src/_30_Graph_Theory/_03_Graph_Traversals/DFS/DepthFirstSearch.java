package _30_Graph_Theory.Graph_Traversals.DFS;

import java.util.ArrayList;

public class DepthFirstSearch {

    // Main DFS function that explores all graph components
    private ArrayList<Integer> performDFS(ArrayList<ArrayList<Integer>> adj, int v) {
        ArrayList<Integer> dfsResult = new ArrayList<>();
        boolean[] visited = new boolean[v];

        // Traverse all nodes to ensure all components are covered
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfsRecursive(i, adj, visited, dfsResult);
            }
        }
        return dfsResult;
    }

    // Recursive DFS helper function for exploring nodes
    private void dfsRecursive(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> dfsResult) {
        visited[node] = true;
        dfsResult.add(node); // Process the node

        // Visit each unvisited neighbor
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfsRecursive(neighbor, adj, visited, dfsResult);
            }
        }
    }

    public static void main(String[] args) {
        int v = 9; // Total number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);

        // Initialize adjacency list for each vertex
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges for an undirected graph
        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(2).add(1);
        adj.get(2).add(5);
        adj.get(2).add(6);
        adj.get(3).add(1);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(3);
        adj.get(4).add(8);
        adj.get(7).add(3);
        adj.get(7).add(8);
        adj.get(8).add(4);
        adj.get(8).add(7);

        // Create an instance of DepthFirstSearch and perform DFS
        DepthFirstSearch dfsInstance = new DepthFirstSearch();
        ArrayList<Integer> sol = dfsInstance.performDFS(adj, v);

        // Print the DFS traversal result
        //System.out.println("DFS Traversal: " + sol);
        for (int i = 0; i < sol.size(); i++) {
            System.out.print(sol.get(i) + " ");
        }
    }
}
