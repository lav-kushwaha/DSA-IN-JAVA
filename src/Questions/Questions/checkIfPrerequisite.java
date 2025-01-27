package Questions.Questions;

import java.util.*;

//https://leetcode.com/problems/course-schedule-iv/description/
//1462. Course Schedule IV
class checkIfPrerequisite {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        }

        int Q = queries.length; 
        List<Boolean> result = new ArrayList<>(Q);

        for (int i = 0; i < Q; i++) {
            int u = queries[i][0]; 
            int v = queries[i][1];

            boolean[] visited = new boolean[numCourses];
            result.add(dfs(adj, u, v, visited)); 
        }

        return result;
    }

    private boolean dfs(Map<Integer, List<Integer>> adj, int src, int dest, boolean[] visited) {
        visited[src] = true;

        if (src == dest) {
            return true; 
        }

        boolean isReachable = false;
        for (int adjNode : adj.getOrDefault(src, new ArrayList<>())) {
            if (!visited[adjNode]) {
                isReachable = isReachable || dfs(adj, adjNode, dest, visited);
            }
        }

        return isReachable;
    }
}