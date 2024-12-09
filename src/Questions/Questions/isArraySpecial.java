package Questions.Questions;

//https://leetcode.com/problems/special-array-ii/description/
//3152. Special Array II
class isArraySpecial {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        int[] cumSum = new int[n];
        // cumSum[i] = total count of violating indices till index i
        cumSum[0] = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] % 2 == nums[i - 1] % 2) { // violating index
                cumSum[i] = cumSum[i - 1] + 1;
            } else {
                cumSum[i] = cumSum[i - 1];
            }
        }

        boolean[] result = new boolean[m];
        for (int i = 0; i < m; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            if (cumSum[end] - cumSum[start] == 0) {
                result[i] = true;
            } else {
                result[i] = false;
            }
        }

        return result;
    }
}