package _30_Graph_Theory.Graph_Representations.Weighted_Graph;

import java.util.Arrays;

public class WeightedGraphMatrix {
    
    // Method to add an edge with a weight
    public static void addEdge(int[][] matrix, int u, int v, int weight) {
        matrix[u][v] = weight;
        matrix[v][u] = weight; // If the graph is undirected
    }

    // Method to display the adjacency matrix
    public static void display(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4; // Number of vertices
        int[][] matrix = new int[n][n]; // Initialize the adjacency matrix
        
        // Fill the matrix with a default value representing no edge (e.g., Integer.MAX_VALUE)
        for (int[] row : matrix) {
            Arrays.fill(row, Integer.MAX_VALUE); // Or use any large value
        }

        // Add weighted edges
        addEdge(matrix, 0, 1, 5); // Edge between vertex 0 and 1 with weight 5
        addEdge(matrix, 0, 2, 10); // Edge between vertex 0 and 2 with weight 10
        addEdge(matrix, 1, 2, 3); // Edge between vertex 1 and 2 with weight 3
        addEdge(matrix, 2, 3, 1); // Edge between vertex 2 and 3 with weight 1

        // Display the adjacency matrix
        display(matrix);
    }
}
