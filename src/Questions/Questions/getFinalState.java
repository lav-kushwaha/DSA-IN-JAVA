package Questions.Questions;

//Approach (Brute Force)
//T.C : O(n * k)
//S.C : O(1)

//https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/description/
//3264. Final Array State After K Multiplication Operations I
class getFinalState {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;

        for (int j = 0; j < k; j++) {
            int idx = 0;

            for (int i = 0; i < n; i++) {
                if (nums[i] < nums[idx]) {
                    idx = i;
                }
            }

            nums[idx] *= multiplier;
        }

        return nums;
    }
}