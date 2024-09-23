package _30_Graph_Theory.Graph_Representations;

public class Adjacent_Matrix {

    // Method to add an edge in the adjacency matrix
    public static void addEdge(int[][] matrix, int row, int col) {
        matrix[row][col] = 1;
        matrix[col][row] = 1; // For undirected graph, add both directions
    }

    public static void display(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4; // Number of nodes
        int[][] matrix = new int[n][n];

        // Add edges.
        addEdge(matrix, 1, 2); // Edge between node 1 and node 2
        addEdge(matrix, 1, 3); // Edge between node 1 and node 3
        addEdge(matrix, 2, 3); // Edge between node 2 and node 3

        // Display the adjacency matrix
        display(matrix);
    }
}
