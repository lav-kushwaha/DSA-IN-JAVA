package _30_Graph_Theory._05_ShortestPath_Algorithm.Dijkstra_Algorithm.DijkstraAlgoUsingTreeSet;

import java.util.*;

class Pair implements Comparable<Pair> {
    int vertex, weight;

    public Pair(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    public int compareTo(Pair other) {
        return Integer.compare(this.weight, other.weight);
    }
}

public class DijkstraAlgorithm {
    public static ArrayList<Integer> dijkstra(ArrayList<ArrayList<Pair>> adj, int src) {
        int n = adj.size();
        ArrayList<Integer> dis = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));
        
        // TreeSet to efficiently extract the minimum distance node
        TreeSet<Pair> set = new TreeSet<>();
        dis.set(src, 0);
        set.add(new Pair(src, 0));

        while (!set.isEmpty()) {
            Pair current = set.pollFirst(); // Extract the node with minimum distance
            int node = current.vertex;

            for (Pair neighbor : adj.get(node)) {
                int v = neighbor.vertex;
                int wt = neighbor.weight;

                // Relaxation step
                if (dis.get(node) + wt < dis.get(v)) {
                    set.remove(new Pair(v, dis.get(v))); // Remove old distance if present
                    dis.set(v, dis.get(node) + wt);
                    set.add(new Pair(v, dis.get(v))); // Insert updated distance
                }
            }
        }
        return dis;
    }

    public static void main(String[] args) {
        int n = 5; // Number of nodes
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges (Graph Representation)
        adj.get(0).add(new Pair(1, 2));
        adj.get(0).add(new Pair(2, 4));
        adj.get(1).add(new Pair(2, 1));
        adj.get(1).add(new Pair(3, 7));
        adj.get(2).add(new Pair(4, 3));
        adj.get(3).add(new Pair(4, 1));

        // Running Dijkstra from node 0
        ArrayList<Integer> shortestDistances = dijkstra(adj, 0);
        System.out.println("Shortest distances from node 0: " + shortestDistances);
    }
}
