package Questions.Questions;

import java.util.Deque;
import java.util.LinkedList;

//Approach (Using sliding window + monotinic deque)
//T.C : O(n)
//S.C : O(n)
class shortestSubarray {
    public int shortestSubarray(int[] nums, int k) {
        int N = nums.length;
        
        Deque<Integer> deq = new LinkedList<>();
        long[] cumulativeSum = new long[N]; 
        
        int result = Integer.MAX_VALUE;
        int j = 0;

        while (j < N) {
            if (j == 0)
                cumulativeSum[j] = nums[j];
            else
                cumulativeSum[j] = cumulativeSum[j - 1] + nums[j];
            
            if (cumulativeSum[j] >= k) 
                result = Math.min(result, j + 1);
            
            while (!deq.isEmpty() && cumulativeSum[j] - cumulativeSum[deq.peekFirst()] >= k) {
                result = Math.min(result, j - deq.peekFirst());  
                deq.pollFirst(); 
            }

            while (!deq.isEmpty() && cumulativeSum[j] <= cumulativeSum[deq.peekLast()]) {
                deq.pollLast();
            }

            deq.offerLast(j);

            j++; 
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}