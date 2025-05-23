package _30_Graph_Theory._02_Connected_Components;

import java.util.*;

//2. Using DFS to find connected components:

public class ConnectedComponentsDFS {
    
    // Function to perform DFS
    public static void dfs(int node, List<List<Integer>> adjList, boolean[] visited) {
        visited[node] = true;
        // Explore all neighbors
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjList, visited);
            }
        }
    }

    // Function to find connected components
    public static int findConnectedComponents(int n, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[n + 1];
        int componentCount = 0;
        
        // Traverse all nodes
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                // New connected component found, perform DFS
                dfs(i, adjList, visited);
                componentCount++;
            }
        }
        
        return componentCount;
    }

    public static void main(String[] args) {
        int n = 6;  // Number of nodes

        // Create an adjacency list for an undirected graph
        List<List<Integer>> adjList = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add edges (example graph)
        adjList.get(1).add(2);
        adjList.get(2).add(1);

        adjList.get(2).add(3);
        adjList.get(3).add(2);

        adjList.get(4).add(5);
        adjList.get(5).add(4);

        // Find the number of connected components
        int connectedComponents = findConnectedComponents(n, adjList);
        System.out.println("Number of connected components: " + connectedComponents);
    }
}
