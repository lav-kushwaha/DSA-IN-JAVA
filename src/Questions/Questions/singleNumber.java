package Questions.Questions;

class singleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int num : nums){
           result ^= num;
        }
        return result;
    }
}