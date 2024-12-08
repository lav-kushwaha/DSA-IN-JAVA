package Questions.Questions;

//https://leetcode.com/problems/two-best-non-overlapping-events/description/
//2054. Two Best Non-Overlapping Events
import java.util.Arrays;
class binarySearchNonOverlaping {
    private int n;
    private int[][] dp = new int[100001][3];
    
    private int binarySearch(int[][] events, int endTime) {
        int left = 0, right = n - 1, result = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (events[mid][0] > endTime) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private int solve(int[][] events, int i, int count) {
        if (count == 2 || i >= n) {
            return 0;
        }

        if (dp[i][count] != -1) {
            return dp[i][count];
        }

        int nextValidEventIndex = binarySearch(events, events[i][1]);
        int take = events[i][2] + solve(events, nextValidEventIndex, count + 1);
        int notTake = solve(events, i + 1, count);

        dp[i][count] = Math.max(take, notTake);
        return dp[i][count];
    }

    public int maxTwoEvents(int[][] events) {
        n = events.length;
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(events, 0, 0);
    }
}