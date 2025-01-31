package Questions.Questions;

import java.util.*;

//https://leetcode.com/problems/divide-nodes-into-the-maximum-number-of-groups/description/
//2493. Divide Nodes Into the Maximum Number of Groups
class isBipartite {
    public boolean isBipartite(Map<Integer, List<Integer>> adj, int curr, int[] colors, int currColor) {
        colors[curr] = currColor;
        
        for (int ngbr : adj.get(curr)) {
            if (colors[ngbr] == colors[curr]) {
                return false;
            }
            
            if (colors[ngbr] == -1) {
                if (!isBipartite(adj, ngbr, colors, 1 - currColor)) {
                    return false;
                }
            }
        }

        return true;
    }

    public int bfs(Map<Integer, List<Integer>> adj, int currNode, int n) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[n];
        que.add(currNode);
        visited[currNode] = true;

        int level = 1;
        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                int curr = que.poll();
                
                for (int ngbr : adj.get(curr)) {
                    if (visited[ngbr]) continue;
                    
                    que.add(ngbr);
                    visited[ngbr] = true;
                }
            }
            level++;
        }

        return level - 1;
    }

    public int getMaxFromEachComp(Map<Integer, List<Integer>> adj, int curr, boolean[] visited, int[] levels) {
        int maxGrp = levels[curr];
        visited[curr] = true;

        for (int ngbr : adj.get(curr)) {
            if (!visited[ngbr]) {
                maxGrp = Math.max(maxGrp, getMaxFromEachComp(adj, ngbr, visited, levels));
            }
        }

        return maxGrp;
    }

    // Main function to calculate the result
    public int magnificentSets(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Bipartite check
        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        for (int node = 0; node < n; node++) {
            if (colors[node] == -1) {
                if (!isBipartite(adj, node, colors, 1)) {
                    return -1;
                }
            }
        }

        // BFS to find max levels for each node
        int[] levels = new int[n];
        for (int node = 0; node < n; node++) {
            levels[node] = bfs(adj, node, n);
        }

        // Sum the max group sizes for each component
        int maxGroupEachComp = 0;
        boolean[] visited = new boolean[n];
        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                maxGroupEachComp += getMaxFromEachComp(adj, node, visited, levels);
            }
        }

        return maxGroupEachComp;
    }
}