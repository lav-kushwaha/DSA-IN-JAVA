package _30_Graph_Theory._03_Graph_Traversals.BFS;

import java.util.*;

public class BFSUsingMap {
    
    // Method to perform BFS traversal
    public void bfs(Map<Integer, List<Integer>> graph, int start) {
        Queue<Integer> queue = new LinkedList<>(); // Queue to manage nodes to visit
        Set<Integer> visited = new HashSet<>(); // Set to track visited nodes

        // Initialize BFS from the starting node
        queue.add(start); // Add the starting node to the queue
        visited.add(start); // Mark it as visited

        while (!queue.isEmpty()) {
            int node = queue.poll(); // Dequeue the current node
            System.out.print(node + " "); // Process the node (print it here)

            // Explore all neighbors
            for (int neighbor : graph.get(node)) {
                if (!visited.contains(neighbor)) { // If neighbor hasn't been visited
                    queue.add(neighbor); // Enqueue the neighbor
                    visited.add(neighbor); // Mark as visited
                }
            }
        }
    }

    public static void main(String[] args) {
        // Define a graph using an adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(1, 4, 5));
        graph.put(3, Arrays.asList(1, 6));
        graph.put(4, Arrays.asList(2));
        graph.put(5, Arrays.asList(2, 6));
        graph.put(6, Arrays.asList(3, 5));

        // Run BFS starting from node 1
        BFSUsingMap bfsUsingMap = new BFSUsingMap();
        System.out.print("BFS traversal starting from node 1: ");
        bfsUsingMap.bfs(graph, 1);
    }
}

/*
#Complexity Analysis

#Time Complexity: O(V+E)
Where V is the number of vertices and E is the number of edges.
Each vertex and edge is processed once.

#Space Complexity: O(V)
For the queue and visited set.

*/


