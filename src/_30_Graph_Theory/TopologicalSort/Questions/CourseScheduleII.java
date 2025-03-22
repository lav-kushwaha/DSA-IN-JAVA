package _30_Graph_Theory.TopologicalSort.Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        int m = prerequisites.length;
        for(int i=0;i<m;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int indegree [] = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int neighbour:adj.get(i)){
                indegree[neighbour]++;
            }
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }

       int ans [] = new int[numCourses];
       int count = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            ans[count] = node;
            count++;

            for(int neighbour : adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0) queue.add(neighbour);
            }
        }

        return count==numCourses?ans:new int[0];
    }
}