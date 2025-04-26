package _30_Graph_Theory._03_Graph_Traversals.Questions.DFS;
import java.util.*;

//https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
//Cycle in a Directed Graph
class CycleDetectInDirectedGraph {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        int v = adj.size(); // Number of vertices
        int vis[] = new int[v]; // Visited array
        int pathVis[] = new int[v]; // Path visited array

        for (int i = 0; i < v; i++) {
            if (vis[i] == 0) {
                if (dfs(i, vis, pathVis, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int start, int[] vis, int[] pathVis, ArrayList<ArrayList<Integer>> adj) {
        vis[start] = 1;
        pathVis[start] = 1;

        for (int neighbour : adj.get(start)) {
            if (vis[neighbour] == 0) {
                if (dfs(neighbour, vis, pathVis, adj)) {
                    return true;
                }
            } else if (pathVis[neighbour] == 1) {
                return true; // Cycle detected
            }
        }

        pathVis[start] = 0; // Backtrack
        return false;
    }

    public static void main(String[] args) {
        int V = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);

        CycleDetectInDirectedGraph obj = new CycleDetectInDirectedGraph();
        boolean ans = obj.isCyclic(adj);
        if (ans)
            System.out.println("True");
        else
            System.out.println("False");
    }
}
