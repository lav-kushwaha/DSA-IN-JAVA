package _30_Graph_Theory.TopologicalSort.Concept;

import java.util.ArrayList;
import java.util.Stack;

//https://www.geeksforgeeks.org/problems/topological-sort/1
//Topological sort
class TopologicalSortDFS {
    
    // Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        Stack<Integer> stack = new Stack<>();
        
        // Call DFS for each node if not visited yet
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, adj, stack);
            }
        }
        
        // Convert stack to array and return it
        int[] ans = new int[V];
        int index = 0;
        while (!stack.isEmpty()) {
            ans[index++] = stack.pop();
        }
        
        return ans;
    }
    
    // DFS function to perform DFS and store nodes in stack
    public static void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack) {
        vis[node] = 1;  // Mark the node as visited
        
        // Visit all the neighbors
        for (int neighbour : adj.get(node)) {
            if (vis[neighbour] == 0) {
                dfs(neighbour, vis, adj, stack);  // Recurse for unvisited nodes
            }
        }
        
        // Add node to the stack after visiting all neighbors
        stack.push(node);
    }
    
    public static void main(String[] args) {
        // Example Input
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Define edges (directed graph)
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);
        
        // Perform topological sort
        int[] ans = TopologicalSortDFS.topoSort(V, adj);
        
        // Print the result
        for (int node : ans) {
            System.out.print(node + " ");
        }
        System.out.println("");  // Output format
    }
}
