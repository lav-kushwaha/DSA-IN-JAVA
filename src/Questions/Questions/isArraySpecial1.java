package Questions.Questions;

//https://leetcode.com/problems/special-array-i/description/
//3151. Special Array I
class isArraySpecial1 {
    public boolean isArraySpecial(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] % 2 == nums[i + 1] % 2) {
                return false;
            }
        }
        return true;
    }
}