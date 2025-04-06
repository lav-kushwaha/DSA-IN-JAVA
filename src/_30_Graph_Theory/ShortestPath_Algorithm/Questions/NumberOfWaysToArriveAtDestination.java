package _30_Graph_Theory.ShortestPath_Algorithm.Questions;

import java.util.*;

//https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/
//1976. Number of Ways to Arrive at Destination
public class NumberOfWaysToArriveAtDestination {

    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static int countPaths(int n, List<List<Integer>> roads) {
        int m = roads.size();
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected graph
        for (int i = 0; i < m; i++) {
            int u = roads.get(i).get(0);
            int v = roads.get(i).get(1);
            int wt = roads.get(i).get(2);

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        int[] dist = new int[n];
        int[] ways = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        int mod = (int) (1e9 + 7);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.second - b.second);
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.first;
            int weight = curr.second;

            if (weight > dist[node]) continue;

            for (Pair neighbour : adj.get(node)) {
                int adjNode = neighbour.first;
                int edw = neighbour.second;

                if (weight + edw < dist[adjNode]) {
                    dist[adjNode] = weight + edw;
                    ways[adjNode] = ways[node];
                    pq.add(new Pair(adjNode, weight + edw));
                } else if (weight + edw == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1];
    }
}
