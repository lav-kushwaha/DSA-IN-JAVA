package _30_Graph_Theory.Graph_Traversals;
import java.util.*;

//Breadth First Search (BFS): Level Order Traversal

public class BreadthFirstSearch {

    public ArrayList<Integer> bfsTraversals(ArrayList<ArrayList<Integer>> adj, int v) {

        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0); // Start from node 0
        visited[0] = true;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            bfs.add(node);

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            for (int neighbour : adj.get(node)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
        return bfs;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = 5;
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);

        BreadthFirstSearch sl = new BreadthFirstSearch();
        ArrayList<Integer> ans = sl.bfsTraversals(adj, v);

        // Print the BFS traversal result
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}

/*
Output: 0 1 4 2 3
Time Complexity: O(N) + O(2E), Where N = Nodes, 2E is for total degrees as we traverse all adjacent nodes.
Space Complexity: O(3N) ~ O(N), Space for queue data structure visited array and an adjacency list
 */
