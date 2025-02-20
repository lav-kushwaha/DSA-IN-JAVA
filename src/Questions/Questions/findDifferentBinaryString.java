package Questions.Questions;

//https://leetcode.com/problems/find-unique-binary-string/description/
//1980. Find Unique Binary String
class findDifferentBinaryString {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i].charAt(i) == '0') {
                result.append('1');
            } else {
                result.append('0');
            }
        }
        return result.toString();
    }
}