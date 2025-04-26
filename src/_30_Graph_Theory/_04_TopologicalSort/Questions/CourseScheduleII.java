package _30_Graph_Theory._04_TopologicalSort.Questions;

import java.util.*;

//https://leetcode.com/problems/course-schedule-ii/description/
//210. Course Schedule II
class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Step 1: Create adjacency list representation of the graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Fill the adjacency list and calculate in-degree of each node
        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            adj.get(prereq).add(course);
            indegree[course]++;  // Increase in-degree for course
        }

        // Step 3: Add all nodes with in-degree 0 to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Step 4: Process nodes using BFS
        int[] result = new int[numCourses];
        int count = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result[count] = node; // Store in result array
            count++;

            // Reduce the in-degree of its neighbors
            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Step 5: If we processed all courses, return result, otherwise return empty array
        return (count == numCourses) ? result : new int[0];
    }

    // Main function to test the code
    public static void main(String[] args) {
        CourseScheduleII obj = new CourseScheduleII();
        int numCourses = 4;
        int[][] prerequisites = { {1, 0}, {2, 0}, {3, 1}, {3, 2} };

        int[] order = obj.findOrder(numCourses, prerequisites);
        if (order.length == 0) {
            System.out.println("No valid course order (cycle detected).");
        } else {
            System.out.print("Course Order: ");
            for (int course : order) {
                System.out.print(course + " ");
            }
        }
    }
}
