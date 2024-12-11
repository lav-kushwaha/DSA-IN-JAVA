package Questions.Questions;
import java.util.Arrays;

//https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation/description/
//2779. Maximum Beauty of an Array After Applying Operation

class maximumBeauty {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0, j = 0;
        int maxBeauty = 0;

        while (i < n) {
            while (j < n && nums[j] - nums[i] <= 2 * k) {
                j++;
            }

            maxBeauty = Math.max(maxBeauty, j - i);
            i++;
        }

        return maxBeauty;
    }
}