package Questions.SEP;

//https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/?envType=daily-question&envId=2024-09-14
//2419. Longest Subarray With Maximum Bitwise AND

class LongestSubarray {
    public static int longestSubarray(int[] nums) {
        int maxVal = 0, result = 0, continuous = 0;
        
        for (int num : nums) {
            if (num > maxVal) {
                maxVal = num;
                result = 0;  
                continuous = 0;  
            }
            if (num == maxVal) {
                continuous++;
            } else {
                continuous = 0;  
            }
            
            result = Math.max(result, continuous);
        }
        
        return result;
    }
    public static void main(String[] args) {

        int[] nums = {1, 2, 2, 3, 3, 3, 2};

        System.out.println(longestSubarray(nums));
    }
}
