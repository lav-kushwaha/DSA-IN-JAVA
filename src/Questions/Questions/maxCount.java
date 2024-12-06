package Questions.Questions;
import java.util.HashSet;

//https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/description/
//2554. Maximum Number of Integers to Choose From a Range I
class maxCount {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : banned) {
            set.add(num);
        }

        int count = 0;
        int sum = 0;

        for (int num = 1; num <= n; num++) {
            if (set.contains(num)) {
                continue;
            }

            if (sum + num <= maxSum) {
                count++;
                sum += num;
            } else {
                break;
            }
        }

        return count;
    }
}