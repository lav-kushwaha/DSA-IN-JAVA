package Questions.Questions;

import java.util.*;

//Approach (Using BFS)
//T.C : O(V+E)
//S.C : O(V+E)

//https://leetcode.com/problems/find-minimum-diameter-after-merging-two-trees/description/
//3203. Find Minimum Diameter After Merging Two Trees
public class buildAdjList {
    public Map<Integer, List<Integer>> buildAdjList(int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        return adjList;
    }

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        Map<Integer, List<Integer>> adj1 = buildAdjList(edges1);
        Map<Integer, List<Integer>> adj2 = buildAdjList(edges2);

        int d1 = findDiameter(adj1);
        int d2 = findDiameter(adj2);

        int combined = (d1 + 1) / 2 + (d2 + 1) / 2 + 1;

        return Math.max(Math.max(d1, d2), combined);
    }

    public int findDiameter(Map<Integer, List<Integer>> adjList) {
        List<Integer> farthestNode = BFS(adjList, 0);

        farthestNode = BFS(adjList, farthestNode.get(0));
        return farthestNode.get(1);
    }

    public List<Integer> BFS(Map<Integer, List<Integer>> adjList, int sourceNode) {
        Queue<Integer> que = new LinkedList<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        
        que.add(sourceNode);
        visited.put(sourceNode, true);

        int maxDistance = 0, farthestNode = sourceNode;

        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int currentNode = que.poll();
                farthestNode = currentNode;

                for (int neighbor : adjList.getOrDefault(currentNode, new ArrayList<>())) {
                    if (!visited.getOrDefault(neighbor, false)) {
                        visited.put(neighbor, true);
                        que.add(neighbor);
                    }
                }
            }
            if (!que.isEmpty()) {
                maxDistance++;
            }
        }
        return Arrays.asList(farthestNode, maxDistance);
    }
}