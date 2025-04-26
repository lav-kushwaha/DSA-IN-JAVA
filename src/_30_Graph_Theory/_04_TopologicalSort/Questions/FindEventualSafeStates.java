package _30_Graph_Theory._04_TopologicalSort.Questions;

import java.util.*;

//https://leetcode.com/problems/find-eventual-safe-states/description/
//802. Find Eventual Safe States
class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        
        // Initialize reversed adjacency list
        for (int i = 0; i < v; i++) {
            adjRev.add(new ArrayList<>());
        }

        int[] indegree = new int[v];

        // Reverse the graph and calculate in-degree
        for (int i = 0; i < v; i++) {
            for (int neighbour : graph[i]) {
                adjRev.get(neighbour).add(i); // Reverse edge
                indegree[i]++; // Increase indegree of i (was a destination in original graph)
            }
        }

        // Topological sorting using BFS (Kahn's Algorithm)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            safeNodes.add(node);
            for (int neighbour : adjRev.get(node)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        Collections.sort(safeNodes); // Ensure lexicographical order
        return safeNodes;
    }

    // Main method for testing
    public static void main(String[] args) {
        FindEventualSafeStates solution = new FindEventualSafeStates();
        int[][] graph = {
            {1, 2}, 
            {2, 3}, 
            {5}, 
            {0}, 
            {5}, 
            {}, 
            {}
        };
        System.out.println(solution.eventualSafeNodes(graph)); // Output: [2, 4, 5, 6]
    }
}
