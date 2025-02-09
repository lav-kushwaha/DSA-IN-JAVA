package Questions.Questions;
import java.util.*;

//https://leetcode.com/problems/count-number-of-bad-pairs/description/
//2364. Count Number of Bad Pairs
public class countBadPairs {
    public long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        long good = 0;
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i] - i;
            good += freq.getOrDefault(key, 0);
            freq.put(key, freq.getOrDefault(key, 0) + 1);
        }
        return (long) nums.length * (nums.length - 1) / 2 - good;
    }
}