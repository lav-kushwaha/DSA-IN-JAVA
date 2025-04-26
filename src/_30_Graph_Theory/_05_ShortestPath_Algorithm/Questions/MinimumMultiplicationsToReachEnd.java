package _30_Graph_Theory._05_ShortestPath_Algorithm.Questions;

import java.util.*;

//https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1
//Minimum Multiplications to reach End
class MinimumMultiplicationsToReachEnd {
    
    class Pair{
        int num, steps;
        Pair(int num, int steps){
            this.num = num;
            this.steps = steps;
        }
    }
    
    int minimumMultiplications(int[] arr, int start, int end) {
    
    if (start == end) return 0; 
        
    int mod = 100000;
    int[] dist = new int[mod];
    Arrays.fill(dist, Integer.MAX_VALUE); 
    dist[start] = 0;
    
    Queue<Pair> queue = new LinkedList<>();
    queue.add(new Pair(start, 0));
    
    while (!queue.isEmpty()) {
        Pair curr = queue.poll();
        int currNum = curr.num;
        int currSteps = curr.steps;
        
        for (int i = 0; i < arr.length; i++) {
            int num = (arr[i] * currNum) % mod;
            if (currSteps + 1 < dist[num]) {
                dist[num] = currSteps + 1;
                if (num == end) return currSteps + 1;
                queue.add(new Pair(num, currSteps + 1));
            }
        }
    }
    
    return -1;
}

}