package Questions.SEP;

import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/minimum-time-difference/description/
//539. Minimum Time Difference

class findMinTimeDifference {

    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();

        // If there are more time points than the possible number of minutes in a day, return 0.
        // This is because there must be duplicate times, leading to a difference of 0.
        if (n > 1440) return 0;

        int[] minutes = new int[n];

        // Convert timePoints to minutes since 00:00
        for (int i = 0; i < n; i++) {
            String time = timePoints.get(i);
            String[] parts = time.split(":");

            int hours = Integer.parseInt(parts[0]);
            int mins = Integer.parseInt(parts[1]);

            minutes[i] = hours * 60 + mins;
        }

        // Sort the minutes array to compare adjacent time points
        Arrays.sort(minutes);

        // Initialize result with the maximum possible value
        int result = Integer.MAX_VALUE;

        // Find the minimum difference between adjacent times
        for (int i = 1; i < n; i++) {
            result = Math.min(result, minutes[i] - minutes[i - 1]);
        }

        // Check the circular case (between the first and last times)
        result = Math.min(result, (24 * 60 - minutes[n - 1]) + minutes[0]);

        return result;
    }

    public static void main(String[] args) {
        findMinTimeDifference obj = new findMinTimeDifference();
        List<String> timePoints = Arrays.asList("23:59", "00:00", "12:30");
        System.out.println("Minimum Time Difference: " + obj.findMinDifference(timePoints));  // Output: 1
    }
}
