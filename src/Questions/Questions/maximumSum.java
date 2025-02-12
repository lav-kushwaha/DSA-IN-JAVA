package Questions.Questions;

//https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/description/
//2342. Max Sum of a Pair With Equal Sum of Digits
class maximumSum {
    public int maximumSum(int[] nums) {
        int[] max = new int[82];
        int ans = -1;
        for (int x : nums) {
            int sum = 0;
            int temp = x;
            while (temp != 0) {
                sum += temp % 10;
                temp /= 10;
            }
            if (max[sum] != 0) {
                ans = Math.max(ans, x + max[sum]);
            }
            max[sum] = Math.max(max[sum], x);
        }
        return ans;
    }
}