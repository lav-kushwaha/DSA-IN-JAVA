package _30_Graph_Theory.ShortestPath_Algorithm.DijkstraAlgoUsingPQ;

import java.util.*;

//https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
//Dijkstra Algorithm to finding the shortest path.
class iPair {
    int first, second;

    public iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class DijkstraAlgorithm {
    public static ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        int n = adj.size();
        ArrayList<Integer> dis = new ArrayList<>();

        //Initialize ArrayList initially with max value.
        for(int i=0;i<n;i++){
            dis.add(Integer.MAX_VALUE);
        }
        
        // Min-Heap to prioritize smaller distances
        PriorityQueue<iPair> pq = new PriorityQueue<>((a, b) -> a.second - b.second);
        
        // Initialize source distance as 0
        dis.set(src, 0);
        pq.add(new iPair(src, 0));

        while (!pq.isEmpty()) {
            iPair current = pq.poll();
            int node = current.first;
//            int dist = current.second;

            // Iterate over adjacent nodes
            for (iPair neighbor : adj.get(node)) {
                int v = neighbor.first;
                int wt = neighbor.second;

                // Relaxation step
                if (dis.get(node) + wt < dis.get(v)) {
                    dis.set(v, dis.get(node) + wt);
                    pq.add(new iPair(v, dis.get(v))); // Push updated distance into min-heap
                }
            }
        }

        return dis;
    }

    public static void main(String[] args) {
        int n = 5; // Number of nodes
        ArrayList<ArrayList<iPair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges (Graph Representation)
        adj.get(0).add(new iPair(1, 2));
        adj.get(0).add(new iPair(2, 4));
        adj.get(1).add(new iPair(2, 1));
        adj.get(1).add(new iPair(3, 7));
        adj.get(2).add(new iPair(4, 3));
        adj.get(3).add(new iPair(4, 1));

        // Running Dijkstra from node 0
        ArrayList<Integer> shortestDistances = dijkstra(adj, 0);
        System.out.println("Shortest distances from node 0: " + shortestDistances);
    }
}
