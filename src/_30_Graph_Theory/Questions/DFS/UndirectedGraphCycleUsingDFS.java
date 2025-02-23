package _30_Graph_Theory.Questions.DFS;

import java.util.*;

//https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/
//Undirected Graph Cycle
class UndirectedGraphCycleUsingDFS {
    public boolean hasCycle(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        boolean[] visited = new boolean[n];

        // Traverse all components of the graph
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (hasCycleDFS(i, -1, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasCycleDFS(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (hasCycleDFS(neighbor, node, visited, adj)) {
                    return true;
                }
            } else if (neighbor != parent) { 
                return true; // A cycle is detected
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of vertices and edges
        System.out.print("Enter number of vertices: ");
        int vertices = scanner.nextInt();
        System.out.print("Enter number of edges: ");
        int edges = scanner.nextInt();

        // Initialize adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }

        // Input edges
        System.out.println("Enter the edges (u v) where 0 ≤ u,v < vertices:");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u); // Since the graph is undirected
        }

        // Create instance and check for cycle
        UndirectedGraphCycleUsingDFS graph = new UndirectedGraphCycleUsingDFS();
        boolean hasCycle = graph.hasCycle(adj);

        // Output result
        if (hasCycle) {
            System.out.println("Cycle detected in the graph.");
        } else {
            System.out.println("No cycle found in the graph.");
        }

        scanner.close();
    }
}
