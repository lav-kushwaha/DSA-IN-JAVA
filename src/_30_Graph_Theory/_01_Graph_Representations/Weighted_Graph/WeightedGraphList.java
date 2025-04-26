package _30_Graph_Theory.Graph_Representations.Weighted_Graph;

import java.util.LinkedList;
import java.util.List;

public class WeightedGraphList {

    // Inner class to represent a weighted edge
    static class Edge {
        int dest;
        int weight;
        
        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
        
        @Override
        public String toString() {
            return "(" + dest + ", " + weight + ")";
        }
    }

    // Method to add an edge
    public static void addEdge(List<Edge>[] graph, int u, int v, int weight) {
        graph[u].add(new Edge(v, weight));
        graph[v].add(new Edge(u, weight)); // If the graph is undirected
    }

    // Method to display the adjacency list
    public static void display(List<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            System.out.print("Vertex " + i + ": ");
            for (Edge edge : graph[i]) {
                System.out.print(edge + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4; // Number of vertices
        List<Edge>[] graph = new LinkedList[n]; // Initialize adjacency list
        
        // Initialize each list
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        // Add weighted edges
        addEdge(graph, 0, 1, 5); // Edge between vertex 0 and 1 with weight 5
        addEdge(graph, 0, 2, 10); // Edge between vertex 0 and 2 with weight 10
        addEdge(graph, 1, 2, 3); // Edge between vertex 1 and 2 with weight 3
        addEdge(graph, 2, 3, 1); // Edge between vertex 2 and 3 with weight 1

        // Display the adjacency list
        display(graph);
    }
}
