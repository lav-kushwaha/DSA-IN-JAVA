package Questions.Questions;

//https://leetcode.com/problems/best-sightseeing-pair/description/
//1014. Best Sightseeing Pair
class maxScoreSightseeingPair {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;

        int result = 0;

        int maxTillNow = values[0] + 0;

        for (int j = 1; j < n; j++) {
            int x = values[j] - j;
            int y = maxTillNow;

            result = Math.max(result, x + y);

            maxTillNow = Math.max(maxTillNow, values[j] + j);
        }

        return result;
    }
}