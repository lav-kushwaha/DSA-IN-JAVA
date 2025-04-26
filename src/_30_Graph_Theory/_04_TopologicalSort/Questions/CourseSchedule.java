package _30_Graph_Theory._04_TopologicalSort.Questions;

import java.util.*;

//https://leetcode.com/problems/course-schedule/description/
//207. Course Schedule
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Initialize adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Build the graph (adjacency list)
        int m = prerequisites.length;
        for (int i = 0; i < m; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }


        // Step 3: Compute indegrees (number of incoming edges)
        int indegree[] = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int neighbour : adj.get(i)) {
                indegree[neighbour]++;
            }
        }

        // Step 4: Initialize queue with courses that have no prerequisites (indegree == 0)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Step 5: Perform BFS (Kahn's algorithm for topological sorting)
        List<Integer> topo = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topo.add(node);

            for (int neighbour : adj.get(node)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        // Step 6: If the number of nodes in the topological order equals numCourses, it is possible to finish
        return topo.size() == numCourses;
    }

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        
        // Test case 1
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println(courseSchedule.canFinish(numCourses1, prerequisites1)); // Output: true
        
        // Test case 2
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println(courseSchedule.canFinish(numCourses2, prerequisites2)); // Output: false
    }
}
