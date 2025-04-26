package _30_Graph_Theory.ShortestPath_Algorithm.FloydWarshallAlgorithm;

//https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1
//Floyd Warshall
public class FloydWarshall {
    public static void floydWarshall(int[][] dist) {
        int n = dist.length;

        // Step 1: Replace -1 with large value and set dist[i][i] = 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == -1) dist[i][j] = (int) 1e8;
                if (i == j) dist[i][j] = 0;
            }
        }

        // Step 2: Core Floyd-Warshall algorithm
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][via] < 1e8 && dist[via][j] < 1e8) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                    }
                }
            }
        }

        // Step 3: Replace large values back to -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == (int) 1e8) dist[i][j] = -1;
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 3, -1, 5},
            {-1, 0, 1, -1},
            {-1, -1, 0, 2},
            {-1, -1, -1, 0}
        };

        floydWarshall(graph);

        // Print shortest distances
        System.out.println("Shortest distances between all pairs:");
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
