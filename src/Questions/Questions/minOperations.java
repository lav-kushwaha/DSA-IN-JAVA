package Questions.Questions;
import java.util.*;

//https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/description/
//3066. Minimum Operations to Exceed Threshold Value II
class minOperations {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            if (num < k) pq.add(num);
        }

        int operations = 0;

        while (!pq.isEmpty()) {
            int x = pq.poll();
            operations++;

            if (pq.isEmpty()) break;

            int y = pq.poll();
            long newValue = 2L * x + y;

            if (newValue < k) pq.add((int) newValue);
        }
        return operations;
    }
}