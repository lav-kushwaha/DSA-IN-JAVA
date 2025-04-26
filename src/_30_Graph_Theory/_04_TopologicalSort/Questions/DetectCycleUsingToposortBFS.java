package _30_Graph_Theory._04_TopologicalSort.Questions;

import java.util.*;

//https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
//Cycle in a Directed Graph
class DetectCycleUsingToposortBFS {

    // Function to detect cycle in a directed graph using topological sort (BFS)
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        int[] indegree = new int[V];

        // Step 1: Calculate in-degree for all vertices
        for (int i = 0; i < V; i++) {
            for (int neighbour : adj.get(i)) {
                indegree[neighbour]++;
            }
        }

        // Step 2: Initialize queue and add all nodes with zero in-degree
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Step 3: Count of nodes processed
        int count = 0;

        // Step 4: Process the nodes using BFS
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;

            // Decrease in-degree for all neighbors of the node
            for (int neighbour : adj.get(node)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    queue.add(neighbour); // Add to queue if in-degree becomes zero
                }
            }
        }

        // Step 5: If the count of processed nodes is equal to V, there is no cycle
        // If count is less than V, it means some nodes have not been processed, indicating a cycle
        return count != V; // If count != V, there is a cycle
    }

    public static void main(String[] args) {
        // Create a graph as an adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 4;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Example directed graph: 0 -> 1 -> 2 -> 3
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1); // Adding a back edge to create a cycle (1 -> 2)

        // Check if the graph has a cycle
        DetectCycleUsingToposortBFS solution = new DetectCycleUsingToposortBFS();
        boolean hasCycle = solution.isCyclic(adj);

        // Print result
        System.out.println("Graph has cycle: " + hasCycle);
    }
}
