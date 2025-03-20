package _30_Graph_Theory.TopologicalSort.Concept;

import java.util.*;

//https://www.geeksforgeeks.org/problems/topological-sort/1
//Topological sort Using BFS (Kahn's algorithm)
class TopologicalSortBFS {
    // Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int topo[] = new int[V];
        int i = 0;
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo[i++] = node;

            // For each adjacent node, reduce its in-degree
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        return topo;
    }
        public static void main(String[] args) {
            int V = 6;
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            adj.get(2).add(3);
            adj.get(3).add(1);
            adj.get(4).add(0);
            adj.get(4).add(1);
            adj.get(5).add(0);
            adj.get(5).add(2);

            int[] ans = TopologicalSortBFS.topoSort(V, adj);
            for (int node : ans) {
                System.out.print(node + " ");
            }
            System.out.println("");
        }
}


