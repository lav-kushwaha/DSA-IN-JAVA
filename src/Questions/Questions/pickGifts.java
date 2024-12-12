package Questions.Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/take-gifts-from-the-richest-pile/description/
//2558. Take Gifts From the Richest Pile

public class pickGifts {

    public long pickGifts(int[] gifts, int k) {
        
        List<Integer> giftsList = new ArrayList<>();
        for (int gift : gifts) {
            giftsList.add(-gift);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(giftsList);
        while(k-- > 0) {
            
            int maxElement = -pq.poll();

            
            pq.offer(-(int) Math.sqrt(maxElement));
        }

        long numberOfRemainingGifts = 0;
        while (!pq.isEmpty()) {
            numberOfRemainingGifts -= pq.poll();
        }

        return numberOfRemainingGifts;
    }
}